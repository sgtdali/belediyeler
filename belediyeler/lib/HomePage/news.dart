import 'package:belediyeler/HomePage/NewsDetail.dart';
import 'package:belediyeler/firebase/news.dart';
import 'package:belediyeler/firebase/realtimefirebase.dart';
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
  List tarih = [];
  String post2;
  var aaa;
  var bbb;
  int i = 1;
  int c = 5;
  bool loading = true;
  ScrollController _scrollController = new ScrollController();

  @override
  void initState() {
    //int i = 1;
    postList = [];
    tarih = [];
    super.initState();
    getDatatarih();

    _scrollController.addListener(() {
      if (_scrollController.position.pixels ==
          _scrollController.position.maxScrollExtent) {
        getData(tarih[c]['name']);
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
                    RealTimeDatabase.tarih[index]['haberbaslik'],
                    RealTimeDatabase.tarih[index]['url'],
                    RealTimeDatabase.tarih[index]['belediye'],
                    RealTimeDatabase.tarih[index]['tarih'],
                    tarih[index]['name']);
        },
        itemCount: postList.length,
      ),
    );
  }

  Widget newsUI(String haberbaslik, String URL, String belediye, String tarih,
      String index) {
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
            NewsDetail(URL, haberbaslik, belediye, tarih, index)));
      },
    );
  }

  getDatatarih() async {
    DatabaseReference postref2 = await FirebaseDatabase.instance
        .reference()
        .child('İBB')
        .child('habertarihleri');
    postref2.once().then((DataSnapshot snap) {
      var DATA = snap.value;

      for (var dat in DATA) {
        aaa = dat['name'];
        bbb = dat['tarih'];
        tarih.add({'name': aaa, 'tarih': bbb});
      }

      setState(() {
        tarih.sort((a, b) {
          var adate = a['tarih']; //before -> var adate = a.expiry;
          var bdate = b['tarih']; //var bdate = b.expiry;
          return bdate.compareTo(adate);
        });
      });
      for (int b = 0; b < 5; b++) {
        String name = tarih[b]['name'];
        getData(name);
      }
    });
  }

  getData(String b) {
    DatabaseReference postref2 = FirebaseDatabase.instance
        .reference()
        .child('İBB')
        .child('haberler')
        .child(b);
    postref2.once().then((DataSnapshot snap) {
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
    return;
  }

/*getData5() {
    for (int b = 0; b < 5; b++) {

      String name=tarih[b]['name'];
      getData(name);
    }
  }*/
}