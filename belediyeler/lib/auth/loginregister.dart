import 'package:flutter/material.dart';

class LoginRegister extends StatefulWidget {
  @override
  _LoginRegisterState createState() => _LoginRegisterState();
}

class _LoginRegisterState extends State<LoginRegister> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('loginregister'),
      ),
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: <Widget>[
            RaisedButton(
              color: Colors.black12,
              textColor: Colors.white,
              child: Text('Giriş Yap'),
              onPressed: () {},
            ),
            RaisedButton(
              color: Colors.black12,
              textColor: Colors.white,
              child: Text('Kayıt Ol'),
              onPressed: () {},
            ),
          ],
        ),
      ),
    );
  }
}
