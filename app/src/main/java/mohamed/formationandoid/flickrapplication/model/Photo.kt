package mohamed.formationandoid.flickrapplication.model

class Photo(
    val id: String,
    val owner: String,
    val secret: String,
    val server: String,
    val farm: String,
    val title: String,
    val ispublic: Int,
    val isfriend: Int,
    val isfamily: Int) {

}