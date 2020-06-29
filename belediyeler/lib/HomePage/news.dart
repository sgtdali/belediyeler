import 'package:belediyeler/HomePage/NewsDetail.dart';
import 'package:belediyeler/firebase/news.dart';
import 'package:belediyeler/shared/spinner.dart';
import 'package:firebase_database/firebase_database.dart';
import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';

class News extends StatefulWidget {
  @override
  _NewsState createState() => _NewsState();
}

class _NewsState extends State<News> {
  List<News1> postList = [];
  String post2;
  int i = 1;
  int c = 5;
  bool loading = true;
  ScrollController _scrollController = new ScrollController();

  @override
  void initState() {
    //int i = 1;
    postList = [];
    super.initState();
    getData5();

    _scrollController.addListener(() {
      if (_scrollController.position.pixels ==
          _scrollController.position.maxScrollExtent) {
        getData(c);
        c = c + 1;
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
              postList[index].haberbaslik, postList[index].url, index);
        },
        itemCount: postList.length,
      ),
    );
  }

  Widget newsUI(String haberbaslik, String URL, int index) {
    return GestureDetector(
      child: SingleChildScrollView(
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
                    child: Text("İBB"),
                  ),
                  Container(
                      padding: EdgeInsets.only(right: 10),
                      child: Text("26.06.2020")),
                ],
              ),
              Row(
                children: <Widget>[
                  Container(
                    height: 100,
                    padding: EdgeInsets.fromLTRB(10, 10, 10, 5),
                    child: Image.network(URL),
                  ),
                  SizedBox(
                    width: 20,
                  ),
                  Expanded(
                    child: Container(
                      child: Text(haberbaslik),
                    ),
                  ),
                ],
              ),
              SizedBox(
                height: 7,
              ),
            ],
          ),
        ),
      ),
      onTap: () {
        Navigator.push(context, MaterialPageRoute(builder: (context) =>
            NewsDetail(URL, haberbaslik, index)));
      },
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

      News1 news1 = new News1(
        DATA['haberbaslik'],
        DATA['url'],
        DATA['habericerik1'],
        DATA['habericerik2'],
      );

      post2 = DATA['haberbaslik'];

      setState(() {
        postList.add(news1);

        loading = false;
      });
    });
    return b;
  }

  getData5() {
    for (int b = i; b < 5; b++) {
      getData(b);
    }
  }
}