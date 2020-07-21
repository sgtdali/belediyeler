import 'package:belediyeler/HomePage/mainpage.dart';
import 'package:belediyeler/auth/loginregister.dart';
import 'package:belediyeler/firebase/belediyeler.dart';
import 'package:belediyeler/firebase/firebase.dart';
import 'package:cloud_firestore/cloud_firestore.dart';
import 'package:flutter/material.dart';
import 'package:provider/provider.dart';

import 'firebase/users.dart';

class Chooser extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    final user = Provider.of<Users>(context);

    if (user == null) {
      return LoginRegister();
    } else {
      return MultiProvider(
        providers: [StreamProvider<DocumentSnapshot>.value(
            value: DatabaseService(uid: user.uid).follow)
          , StreamProvider<List<Belediyeler>>.value(
            value: DatabaseService().belediyeleer,
          )
        ],
        child: homepage(),
      );
    }
  }
}
