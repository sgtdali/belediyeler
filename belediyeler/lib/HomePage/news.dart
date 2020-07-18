import 'package:belediyeler/HomePage/NewsDetail.dart';
import 'package:belediyeler/firebase/firebase.dart';
import 'package:belediyeler/firebase/news.dart';
import 'package:belediyeler/firebase/realtimefirebase.dart';
import 'package:belediyeler/firebase/users.dart';
import 'package:belediyeler/shared/spinner.dart';
import 'package:cloud_firestore/cloud_firestore.dart';
import 'package:firebase_database/firebase_database.dart';
import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:provider/provider.dart';

class News extends StatefulWidget {
  @override
  _NewsState createState() => _NewsState();
}

class _NewsState extends State<News> {
  List<News1> postList = [];
  List tarih = [];
  String post2;
  var aaa;
  var bbb;
  int i = 1;
  int c = 5;
  Icon icon = Icon(Icons.favorite_border);
  bool like = false;
  bool loading = true;
  ScrollController _scrollController = new ScrollController();

  @override
  void initState() {
    //int i = 1;
    postList = [];
    tarih = [];
    super.initState();
    getData5();

    _scrollController.addListener(() {
      if (_scrollController.position.pixels ==
          _scrollController.position.maxScrollExtent) {
        for (var a = 0; a < 3; a++) {
          getData(c);
          c = c + 1;
        }
      }
    });
  }

  @override
  void dispose() {
    _scrollController.dispose();
    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
    return loading
        ? spinner()
        : Scaffold(
      body: ListView.builder(
        controller: _scrollController,
        itemBuilder: (_, index) {
          return newsUI(
                    postList[index].haberbaslik,
                    postList[index].url,
                    postList[index].belediye,
                    postList[index].tarih,
                    index,
                    context);
              },
        itemCount: postList.length,
      ),
    );
  }

  Widget newsUI(String haberbaslik, String URL, String belediye, String tarih,
      int index, BuildContext context) {
    var follows = Provider.of<DocumentSnapshot>(context);
    final user = Provider.of<Users>(context);
    List asdf = follows['follow'];
    for (var i = 0; i < asdf.length; i++) {
      if (belediye == asdf[i]) {
        icon = Icon(Icons.favorite, color: Colors.red,);
        break;
      } else {
        icon = Icon(Icons.favorite_border);
      }
    }


    return GestureDetector(
      child: SingleChildScrollView(
        child: Container(
          height: MediaQuery
              .of(context)
              .size
              .height * 0.28,
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

                      height: MediaQuery
                          .of(context)
                          .size
                          .height * 0.16,
                      width: MediaQuery
                          .of(context)
                          .size
                          .height * 0.16,

                      padding: EdgeInsets.fromLTRB(10, 10, 10, 0),
                      child: Image.network(URL),
                    ),
                    SizedBox(

                      width: MediaQuery
                          .of(context)
                          .size
                          .height * 0.01,
                    ),
                    Expanded(
                      child: Container(

                        padding: EdgeInsets.fromLTRB(10, 10, 10, 0),
                        child: Text(haberbaslik),
                      ),
                    ),
                  ],
                ),
                Row(
                  mainAxisAlignment: MainAxisAlignment.end,

                  children: <Widget>[
                    Container(
                      padding: EdgeInsets.all(0),
                      width: MediaQuery
                          .of(context)
                          .size
                          .height * 0.05,
                      child: FlatButton(
                          padding: EdgeInsets.all(0),


                          onPressed: () {
                            setState(() {
                              print(icon);


                              if (icon == Icon(Icons.favorite_border)) {
                                DatabaseService _databaseService =
                                new DatabaseService(uid: user.uid);
                                dynamic result = _databaseService
                                    .updateUserFollow(belediye);
                                print("333");
                              } else {
                                DatabaseService _databaseService =
                                new DatabaseService(uid: user.uid);
                                dynamic result = _databaseService
                                    .deleteUserFollow(belediye);
                              }
                            });
                          },

                          child: icon),

                    )
                  ],
                ),
              ],
            ),
          ),
        ),
      ),
      onTap: () {
        Navigator.push(context, MaterialPageRoute(builder: (context) =>
            NewsDetail(URL, haberbaslik, belediye, tarih, index)));
      },
    );
  }


  getData(int b) async {
    DatabaseReference postref2 = FirebaseDatabase.instance
        .reference()
        .child('haberler')
        .child(RealTimeDatabase.tarih[b]['name']);
    await postref2.once().then((DataSnapshot snap) {
      var DATA = snap.value;

      News1 news1 = new News1(
        DATA['haberbaslik'],
        DATA['url'],

        DATA['belediye'],
        DATA['tarih'],
      );



      setState(() {
        postList.add(news1);

        loading = false;
      });
    });
  }

  getData5() {
    for (int b = 0; b < 5; b++) {
      getData(b);
    }
  }
}