import 'package:belediyeler/HomePage/belediyelist.dart';
import 'package:belediyeler/HomePage/follow.dart';
import 'package:cloud_firestore/cloud_firestore.dart';
import 'package:flutter/material.dart';
import 'package:provider/provider.dart';

class HomePage extends StatefulWidget {
  @override
  _HomePageState createState() => _HomePageState();
}

class _HomePageState extends State<HomePage> {
  @override
  Widget build(BuildContext context) {
    DocumentSnapshot follows = Provider.of<DocumentSnapshot>(context);
    List aaa = follows['follow'];
    if (aaa.length == 0) {
      return Scaffold(
        body: Center(
          child: RaisedButton(
            elevation: 100,
            child: Text('Belediye Listesi'),
            onPressed: () {
              Navigator.of(context).push(new MaterialPageRoute(
                  builder: (BuildContext context) => belediyeList()));
            },
          ),
        ),
      );
    } else {
      return followPage(context);
    }
  }
}
