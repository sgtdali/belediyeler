import 'package:belediyeler/chooser.dart';
import 'package:belediyeler/firebase/authentication.dart';
import 'package:flutter/material.dart';

class Register extends StatefulWidget {
  @override
  _RegisterState createState() => _RegisterState();
}

class _RegisterState extends State<Register> {
  String _email = '', _password = '', _name = '', _surname = '';
  String _age = '';
  final GlobalKey<FormState> _formkey = GlobalKey<FormState>();
  final AuthService _authService = AuthService();

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Kayıt'),
      ),
      body: SingleChildScrollView(
        child: Container(
          margin: const EdgeInsets.all(10),
          child: Form(
            key: _formkey,
            child: Center(
              child: Column(
                mainAxisAlignment: MainAxisAlignment.center,
                children: <Widget>[
                  TextFormField(
                    validator: (input) {
                      if (input.isEmpty) {
                        return 'Email bölümü boş bırakılamaz.';
                      }
                    },
                    onChanged: (input) {
                      setState(() => _email = input);
                    },
                    decoration: InputDecoration(labelText: 'Email'),
                  ),
                  TextFormField(
                    validator: (input) {
                      if (input.length < 6) {
                        return 'Şifre bölümü boş bırakılamaz.';
                      }
                    },
                    onChanged: (input) {
                      setState(() => _password = input);
                    },
                    decoration: InputDecoration(labelText: 'Şifre'),
                    obscureText: true,
                  ),
                  TextFormField(
                    validator: (input) {
                      if (input.length < 6) {
                        return 'Şifre bölümü boş bırakılamaz.';
                      }
                    },
                    onChanged: (input) {
                      setState(() => _name = input);
                    },
                    decoration: InputDecoration(labelText: 'İsim'),
                  ),
                  TextFormField(
                    validator: (input) {
                      if (input.length < 6) {
                        return 'Şifre bölümü boş bırakılamaz.';
                      }
                    },
                    onChanged: (input) {
                      setState(() => _surname = input);
                    },
                    decoration: InputDecoration(labelText: 'Soyisim'),
                  ),
                  TextFormField(

                    onChanged: (input) {
                      setState(() => _age = input);
                    },
                    decoration: InputDecoration(labelText: 'Yaş'),
                  ),
                  RaisedButton(
                    onPressed: () async {
                      dynamic result =
                      await _authService.registerWithEmailandPassword(
                          _email, _password, _name, _surname, _age);
                      if (result == null) {
                        print('error');
                      } else {
                        print('sig in');
                        Navigator.of(context).pushReplacement(
                            new MaterialPageRoute(
                                builder: (BuildContext context) => Chooser()));
                      }
                    },
                    child: Text('GİRİŞ'),
                  )
                ],
              ),
            ),
          ),
        ),
      ),
    );
  }
}
