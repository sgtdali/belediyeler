import 'package:belediyeler/firebase/userindinfo.dart';
import 'package:belediyeler/firebase/users.dart';
import 'package:flutter/material.dart';
import 'package:provider/provider.dart';

class userList extends StatefulWidget {
  @override
  _userListState createState() => _userListState();
}

class _userListState extends State<userList> {
  @override
  Widget build(BuildContext context) {
    final usersdata = Provider.of<List<Userind>>(context);
    final user = Provider.of<Users>(context);
    String Name;
    String Surname;
    String Age;
    usersdata.forEach((userdata) {
      if (userdata.uid == user.uid) {
        Name = userdata.name;
        Surname = userdata.surname;
        Age = userdata.age;
      }
    });
    return Scaffold(
      body: Center(
        child: Container(
          child: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            children: <Widget>[
              Text(
                Name,
                style: TextStyle(fontSize: 30),
              ),
              SizedBox(
                height: 10,
              ),
              Text(
                Surname,
                style: TextStyle(fontSize: 30),
              ),
              SizedBox(
                height: 10,
              ),
              Text(
                Age,
                style: TextStyle(fontSize: 30),
              ),
            ],
          ),
        ),
      ),
    );
  }
}
