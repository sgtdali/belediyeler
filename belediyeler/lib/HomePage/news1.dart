import 'package:firebase_database/firebase_database.dart';
import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';

class NewsDetail1 extends StatefulWidget {
  @override
  int index;

  NewsDetail1(this.index);

  _NewsDetail1State createState() => _NewsDetail1State(index);
}

class _NewsDetail1State extends State<NewsDetail1> {
  int index;

  _NewsDetail1State(this.index);

  String haber1;
  List<Widget> Liste = [];

  @override
  void initState() {
    // TODO: implement initState
    Liste = [];
    super.initState();
    getData(index + 1);
    print(index);
  }

  @override
  Widget build(BuildContext context) {
    return Expanded(
      child: ListView.builder(
        itemBuilder: (_, index) {
          return Liste[index];
        },
        itemCount: Liste.length,
      ),
    );
  }

  Widget Text1(String Haber) {
    return Container(
      padding: EdgeInsets.all(10),
      child: Column(
        children: <Widget>[
          SizedBox(
            height: 50,
          ),
          Text(Haber),
          SizedBox(
            height: 10,
          ),
        ],
      ),
    );
  }

  getData(int b) {
    DatabaseReference postref2 = FirebaseDatabase.instance
        .reference()
        .child('İBB')
        .child('haberler')
        .child(b.toString());
    postref2.once().then((DataSnapshot snap) {
      var DATA = snap.value;

      for (int i = 1; i < 3; i++) {
        haber1 = DATA['habericerik' + i.toString()];

        setState(() {
          Liste.add(Text1(haber1));
        });
      }
    });
    return b;
  }
}
