package mohamed.formationandoid.flickrapplication.ui.main

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import mohamed.formationandoid.flickrapplication.model.Photo
import mohamed.formationandoid.flickrapplication.model.SearchResult
import mohamed.formationandoid.flickrapplication.repository.Repository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel : ViewModel() {

    val repository = Repository()

    val photo= MutableLiveData<Photo>()
    var photosListe = listOf<Photo>()

    init {
        repository.getPhotos(object : Callback<SearchResult>{
            override fun onResponse(call: Call<SearchResult>, response: Response<SearchResult>) {
                // votre liste est là
                val photos = response.body()?.photos?.photo

                // pourquoi une boucle ? on veut juste la première photo
                // et repérer la liste pour plus tard (voir ci-dessous)
                /*
                for(photo in photos?.photo!!){
                    photosListe.add(photo)
                }
                next()*/
                // on vérifie que la liste n'est pas nulle ou vide
                if (photos != null && photos.isNotEmpty()) {
                    // on repère la liste dans la variable de classe
                    photosListe = photos
                    // on positionne le livedata sur la première photo de la liste
                    photo.value = photos[0]
                    Log.v("Mohamed","Ca marche"+photos[0].title)
                }
            }

            override fun onFailure(call: Call<SearchResult>, t: Throwable) {
                Log.v("Mohamed","Ca marche pas")
            }

        })
    }

    fun next(){
         val actPhoto = photo.value
         var proIndex : Int

        if(actPhoto==null){
            proIndex = 0
        } else {
            val actIndex = photosListe.indexOf(actPhoto)
            proIndex = actIndex + 1
            if(actIndex == photosListe.size - 1){
                proIndex = 0
            }
        }
        photo.value = photosListe[proIndex]
    }
}