import 'package:belediyeler/firebase/authentication.dart';
import 'package:belediyeler/firebase/realtimefirebase.dart';
import 'package:flutter/material.dart';

class HomePage extends StatefulWidget {
  @override
  _HomePageState createState() => _HomePageState();
}

class _HomePageState extends State<HomePage> {
  static AuthService _authService = AuthService();

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Center(
        child: Column(
          children: <Widget>[
            RaisedButton(
              onPressed: () async {
                dynamic result = await _authService.signOut();
              },
              child: Text('Çıkış'),
            ),
            Text(
              'Home',
            ),
            Text(
              RealTimeDatabase.tarih[0]['haberbaslik'],
            ),
          ],
        ),
      ),
    );
  }
}
