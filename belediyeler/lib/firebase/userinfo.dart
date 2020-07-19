import 'package:belediyeler/firebase/firebase.dart';
import 'package:belediyeler/firebase/userindinfo.dart';
import 'package:belediyeler/firebase/users.dart';
import 'package:belediyeler/shared/spinner.dart';
import 'package:flutter/material.dart';
import 'package:provider/provider.dart';

import '../chooser.dart';
import 'authentication.dart';

class userList extends StatefulWidget {
  @override
  _userListState createState() => _userListState();
}

class _userListState extends State<userList> {
  final _formkey = GlobalKey<FormState>();
  String aaa;
  String bbb;
  String ccc;
  static AuthService _authService = AuthService();

  @override
  Widget build(BuildContext context) {
    final usersdata = Provider.of<List<Userind>>(context);
    final user = Provider.of<Users>(context);
    bool loading = false;
    String Name;
    String Surname;
    String Age;
    if (usersdata == null) {
      loading = true;
    } else {
      loading = false;
      usersdata.forEach((userdata) {
        if (userdata.uid == user.uid) {
          Name = userdata.name;
          Surname = userdata.surname;
          Age = userdata.age;
        }
      });
    }

    return loading
        ? spinner()
        : Scaffold(
            body: Center(
              child: Container(
                child: Form(
                  key: _formkey,
                  child: Column(
                    mainAxisAlignment: MainAxisAlignment.center,
                    children: <Widget>[
                      TextFormField(
                        decoration: InputDecoration(
                            hintText: Name,
                            hintStyle: TextStyle(color: Colors.black)),
                        validator: (val) => val.isEmpty ? 'İsim giriniz' : null,
                        onChanged: (input) => setState(() => aaa = input),
                      ),
                      SizedBox(
                        height: 10,
                      ),
                      TextFormField(
                        decoration: InputDecoration(labelText: Surname),
                        validator: (val) => val.isEmpty ? 'İsim giriniz' : null,
                        onChanged: (input) => setState(() => bbb = input),
                      ),
                      SizedBox(
                        height: 10,
                      ),
                      TextFormField(
                        decoration: InputDecoration(labelText: Age),
                        validator: (val) => val.isEmpty ? 'İsim giriniz' : null,
                        onChanged: (input) => setState(() => ccc = input),
                      ),
                      SizedBox(
                        height: 10,
                      ),
                      RaisedButton(
                        onPressed: () async {
                          DatabaseService _databaseService =
                              new DatabaseService(uid: user.uid);
                          dynamic result = await _databaseService
                              .update2UserData(aaa, bbb, ccc);
                          Navigator.of(context).pushReplacement(
                              new MaterialPageRoute(
                                  builder: (BuildContext context) =>
                                      Chooser()));
                        },
                        child: Text('GİRİŞ'),
                      ),
                      RaisedButton(
                        onPressed: () async {
                          dynamic result = await _authService.signOut();
                        },
                        child: Text('Çıkış'),
                      ),
                    ],
                  ),
                ),
              ),
            ),
          );
  }
}
