import 'package:belediyeler/firebase/news.dart';
import 'package:firebase_database/firebase_database.dart';
import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';

class News extends StatefulWidget {
  @override
  _NewsState createState() => _NewsState();
}

class _NewsState extends State<News> {
  List<News1> postList = [];

  @override
  void initState() {
    int i = 1;
    // TODO: implement initState
    super.initState();
    DatabaseReference postref =
        FirebaseDatabase.instance.reference().child('İBB').child('haberler');
    postref.once().then((DataSnapshot snap) {
      var KEYS = snap.value;

      for (var individiualKey in KEYS) {
        DatabaseReference postref2 = FirebaseDatabase.instance
            .reference()
            .child('İBB')
            .child('haberler')
            .child(i.toString());
        postref2.once().then((DataSnapshot snap) {
          News1 news1 = new News1(
            individiualKey['habericerik'],
            individiualKey['url'],
          );
          postList.add(news1);

          i = i + 1;
        });
      }
      setState(() {});
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: ListView.builder(
        itemBuilder: (_, index) {
          return newsUI(postList[index].habericerik, postList[index].url);
        },
        itemCount: postList.length,
      ),
    );
  }

  Widget newsUI(String haberic, String URL) {
    return Card(
      elevation: 10,
      margin: EdgeInsets.all(15),
      child: Container(
        padding: EdgeInsets.all(15),
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
              haberic,
              textAlign: TextAlign.center,
              style: TextStyle(fontWeight: FontWeight.bold),
            ),
          ],
        ),
      ),
    );
  }
}