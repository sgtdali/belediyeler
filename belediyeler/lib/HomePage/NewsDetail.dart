import 'package:belediyeler/firebase/news.dart';
import 'package:flutter/material.dart';
import 'package:belediyeler/auth/loginregister.dart';
import 'package:belediyeler/firebase/news.dart';
import 'package:firebase_database/firebase_database.dart';
import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';

class NewsDetail extends StatelessWidget {

  String URL;
  String haberbaslik;
  String habericerik1;
  String habericerik2;

  NewsDetail(this.URL, this.haberbaslik, this.habericerik1, this.habericerik2  );





  @override
  Widget build(BuildContext context) {

    return Scaffold(
      appBar: AppBar(
        title: Text("deneme"),
      ),
      body:  SingleChildScrollView(
        padding: EdgeInsets.all(20),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.center,
          children: <Widget>[
            Row(
              mainAxisAlignment: MainAxisAlignment.spaceBetween,
              children: <Widget>[
                Text('İBB'),
                Text('26.06.2020'),
              ],
            ),
            SizedBox(
              height: 10,
            ),
            Row(
              mainAxisAlignment: MainAxisAlignment.center,
              children: <Widget>[
                Image.network(
                  URL,
                  fit: BoxFit.cover,
                ),
              ],
            ),
            SizedBox(
              height: 10,
            ),
            Text(
              haberbaslik,
              textAlign: TextAlign.center,
              style: TextStyle(fontWeight: FontWeight.bold),
            ),
            Text(
              habericerik1,
            ),
            Text(habericerik2),
          ],
        ),
      ),
    );
  }
}







