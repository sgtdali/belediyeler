import 'package:belediyeler/chooser.dart';
import 'package:belediyeler/firebase/authentication.dart';
import 'package:flutter/material.dart';
import 'package:provider/provider.dart';

import 'firebase/users.dart';

void main() => runApp(MyApp());

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return StreamProvider<Users>.value(
      value: AuthService().user,
      child: MaterialApp(
        home: Chooser(),
      ),
    );
  }
}
