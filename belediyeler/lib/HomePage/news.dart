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

    /*DatabaseReference postref =
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
            individiualKey['haberbaslik'],
            individiualKey['url'],
            individiualKey['habericerik1'],
            individiualKey['habericerik2'],
          );
          postList.add(news1);

          i = i + 1;
        });
      }
      setState(() {});
    });*/
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
          child: Column(
            children: <Widget>[
              Row(
                mainAxisAlignment: MainAxisAlignment.spaceBetween,
                children: <Widget>[
                  Text("İBB"),
                  Text("26.06.2020"),
                ],
              ),
              Container(
                margin: EdgeInsets.all(10),
                height: 100,
                child: Center(
                  child: ListTile(

                    leading: SizedBox(

                        child: Image.network(URL, fit: BoxFit.fill,)),
                    title: Text(haberbaslik,
                      overflow: TextOverflow.fade,
                    ),
                    //  subtitle: Text(habericerik1),
                  ),
                ),
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
