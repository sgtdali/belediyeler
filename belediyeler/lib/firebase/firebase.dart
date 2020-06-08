import 'package:cloud_firestore/cloud_firestore.dart';

class DatabaseService {
  // collection reference
  final String uid;

  DatabaseService({this.uid});

  final CollectionReference userCollection =
      Firestore.instance.collection('Users');

  Future updateUserData(String name, String surname, String age) async {
    try {
      return await userCollection.document(uid).setData({
        'name': name,
        'surname': surname,
        'age': age,
      });
    } catch (e) {
      print(e.toString());
    }
  }

  Stream<QuerySnapshot> get Users {
    return userCollection.snapshots();
  }
}
