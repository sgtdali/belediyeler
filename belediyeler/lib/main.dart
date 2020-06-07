import 'package:belediyeler/screens/auth/login.dart';
import 'package:belediyeler/screens/auth/register.dart';
import 'package:belediyeler/screens/wrapper.dart';
import 'package:flutter/material.dart';


void main() => runApp(MyApp());

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter Demo',
      theme: ThemeData(primarySwatch: Colors.blue),
      home: Login(),
    );
  }
}

