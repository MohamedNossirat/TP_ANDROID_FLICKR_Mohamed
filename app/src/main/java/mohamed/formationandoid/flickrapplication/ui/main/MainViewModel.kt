package mohamed.formationandoid.flickrapplication.ui.main

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

    val photos= MutableLiveData<Photo>()
    val photosListe = ArrayList<Photo>()

    init {
        repository.getPhotos(object : Callback<SearchResult>{
            override fun onResponse(call: Call<SearchResult>, response: Response<SearchResult>) {
                val photos = response.body()?.photos
                for(photo in photos?.photo!!){
                    photosListe.add(photo)
                }
                next()
            }

            override fun onFailure(call: Call<SearchResult>, t: Throwable) {
                println("ça marche pas")
            }

        })
    }

    fun next(){
         val actPhoto = photos.value
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
        photos.value = photosListe[proIndex]
    }
}