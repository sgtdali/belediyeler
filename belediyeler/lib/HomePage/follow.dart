import 'package:belediyeler/firebase/news.dart';
import 'package:belediyeler/firebase/realtimefirebase.dart';
import 'package:belediyeler/shared/spinner.dart';
import 'package:cloud_firestore/cloud_firestore.dart';
import 'package:firebase_database/firebase_database.dart';
import 'package:flutter/material.dart';
import 'package:provider/provider.dart';

import 'NewsDetail.dart';

class followPage extends StatefulWidget {
  BuildContext context;

  followPage(this.context);

  @override
  _followPageState createState() => _followPageState(context);
}

class _followPageState extends State<followPage> {
  @override
  BuildContext context;

  _followPageState(this.context);

  List<News1> postList = [];
  List tarih = [];
  List follow = [];
  String post2;
  var aaa;
  var bbb;
  int b = 0;
  int i = 1;
  int c = 5;

  bool loading = true;
  bool loading1 = false;
  ScrollController _scrollController = new ScrollController();

  @override
  void didChangeDependencies() {
    // TODO: implement didChangeDependencies
    super.didChangeDependencies();
    var follows = Provider.of<DocumentSnapshot>(context);
    postList = [];
    tarih = [];
    b = 0;

    follow = follows['follow'];
    getData(follow);
  }

  @override
  void initState() {
    // TODO: implement initState
    super.initState();
    _scrollController.addListener(() {
      if (_scrollController.position.pixels ==
          _scrollController.position.maxScrollExtent) {
        getData2(follow);
      }
    });
  }

  @override
  void dispose() {
    super.dispose();
    _scrollController.dispose();
  }

  @override
  Widget build(BuildContext context) {
    var follows = Provider.of<DocumentSnapshot>(context);
    return loading
        ? spinner()
        : Scaffold(
            appBar: AppBar(
              title: Text("Takip Ettiklerim"),
            ),
            body: ListView.builder(
              controller: _scrollController,
              itemBuilder: (_, index) {
                return newsUI(postList[index].haberbaslik, postList[index].url,
                    postList[index].belediye, postList[index].tarih, index);
              },
              itemCount: postList.length,
            ),
          );
  }

  Widget newsUI(String haberbaslik, String URL, String belediye, String tarih,
      int index) {
    return GestureDetector(
      child: SingleChildScrollView(
        child: Container(
          height: MediaQuery.of(context).size.height * 0.28,
          child: Card(
            color: Colors.blueGrey.shade100,
            elevation: 100,
            child: Column(
              children: <Widget>[
                SizedBox(
                  height: 7,
                ),
                Row(
                  mainAxisAlignment: MainAxisAlignment.spaceBetween,
                  children: <Widget>[
                    Container(
                      padding: EdgeInsets.only(left: 10),
                      child: Text(belediye),
                    ),
                    Container(
                        padding: EdgeInsets.only(right: 10),
                        child: Text(tarih)),
                  ],
                ),
                Row(
                  children: <Widget>[
                    Container(
                      height: MediaQuery.of(context).size.height * 0.16,
                      width: MediaQuery.of(context).size.height * 0.16,
                      padding: EdgeInsets.fromLTRB(10, 10, 10, 0),
                      child: Image.network(URL),
                    ),
                    SizedBox(
                      width: MediaQuery.of(context).size.height * 0.01,
                    ),
                    Expanded(
                      child: Container(
                        padding: EdgeInsets.fromLTRB(10, 10, 10, 0),
                        child: Text(haberbaslik),
                      ),
                    ),
                  ],
                ),
              ],
            ),
          ),
        ),
      ),
      onTap: () {
        Navigator.push(
            context,
            MaterialPageRoute(
                builder: (context) =>
                    NewsDetail(URL, haberbaslik, belediye, tarih, index)));
      },
    );
  }

  getData(List follow) async {
    String bbb;
    for (var aa = 0; aa < RealTimeDatabase.tarih.length; aa++) {
      if (RealTimeDatabase.tarih[b]['belediyeismi'] == "istanbul") {
        bbb = "İstanbul Büyükşehir Belediyesi";
      } else {
        bbb = "Ankara Büyükşehir Belediyesi";
      }
      for (var i = 0; i < follow.length; i++) {
        if (follow[i] == bbb) {
          DatabaseReference postref2 = FirebaseDatabase.instance
              .reference()
              .child('haberler')
              .child(RealTimeDatabase.tarih[b]['belediyeismi'])
              .child(RealTimeDatabase.tarih[b]['name']);
          await postref2.once().then((DataSnapshot snap) {
            var DATA = snap.value;

            News1 news1 = new News1(
              DATA['haberbaslik'],
              DATA['url'],
              DATA['belediye'],
              DATA['tarih'],
            );
            print("get data");
            setState(() {
              postList.add(news1);
              loading = false;
            });
          });
        }
      }
      if (postList.length == 5) {
        print(aa);
        break;
      }
      b = b + 1;
    }
  }

  getData2(List follow) async {
    String bbb;
    b = b + 1;
    var cccc = postList.length + 3;
    for (var aa = 0; aa < RealTimeDatabase.tarih.length; aa++) {
      if (RealTimeDatabase.tarih[b]['belediyeismi'] == "istanbul") {
        bbb = "İstanbul Büyükşehir Belediyesi";
      } else {
        bbb = "Ankara Büyükşehir Belediyesi";
      }
      for (var i = 0; i < follow.length; i++) {
        if (follow[i] == bbb) {
          DatabaseReference postref2 = FirebaseDatabase.instance
              .reference()
              .child('haberler')
              .child(RealTimeDatabase.tarih[b]['belediyeismi'])
              .child(RealTimeDatabase.tarih[b]['name']);
          await postref2.once().then((DataSnapshot snap) {
            var DATA = snap.value;

            News1 news1 = new News1(
              DATA['haberbaslik'],
              DATA['url'],
              DATA['belediye'],
              DATA['tarih'],
            );
            print("get data");
            setState(() {
              postList.add(news1);
              loading = false;
            });
          });
        }
      }
      if (postList.length == cccc) {
        break;
      }
      b = b + 1;
    }
  }
}
