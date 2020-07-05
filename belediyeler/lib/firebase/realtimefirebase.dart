import 'package:firebase_database/firebase_database.dart';

class RealTimeDatabase {
  static var aaa;
  static var bbb;
  static List tarih = [];

  dataformfirebase() async {
    DatabaseReference postref2 =
        await FirebaseDatabase.instance.reference().child('haberler');
    await postref2.once().then((DataSnapshot snap) {
      var DATA = snap.value.keys;
      var DATA2 = snap.value;
      for (var dat in DATA) {
        tarih.add(DATA2[dat]);
      }
      tarih.sort((a, b) {
        var adate = a['tarihsiralama']; //before -> var adate = a.expiry;
        var bdate = b['tarihsiralama']; //var bdate = b.expiry;
        return bdate.compareTo(adate);
      });
      print(tarih[1]['haberbaslik']);
    });
  }
}
