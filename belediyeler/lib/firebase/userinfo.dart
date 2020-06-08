import 'package:belediyeler/firebase/users.dart';
import 'package:cloud_firestore/cloud_firestore.dart';
import 'package:flutter/material.dart';
import 'package:provider/provider.dart';

class userList extends StatefulWidget {
  @override
  _userListState createState() => _userListState();
}

class _userListState extends State<userList> {
  @override
  Widget build(BuildContext context) {
    final usersdata = Provider.of<QuerySnapshot>(context);
    final user = Provider.of<User>(context);

    for (var doc in usersdata.documents)
      if (doc.documentID == user.uid) {
        print(doc.data);
      }
    return Container();
  }
}
