package mohamed.formationandoid.flickrapplication.ui.main.list

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.GridLayout
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import mohamed.formationandoid.flickrapplication.R
import mohamed.formationandoid.flickrapplication.model.Photo


class Adapter(val photos : List<Photo>) :
    RecyclerView.Adapter<Adapter.MyViewHolder>() {
    // un ViewHolder permet de stocker la vue de chaque item de la liste
    class MyViewHolder(val v: GridLayout) : RecyclerView.ViewHolder(v)

    // on crée (inflate) le layout "user" et on le place dans le ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            Adapter.MyViewHolder {
        val layout =
            LayoutInflater.from(parent.context).inflate(R.layout.my_photo_grid,parent,false)
        return MyViewHolder(layout as GridLayout)
    }

    override fun getItemCount(): Int = photos.size

    override fun onBindViewHolder(holder: Adapter.MyViewHolder, position:
    Int) {
        val MyPhoto = photos[position]
        val baseUrl = "https://live.staticflickr.com/" + MyPhoto.server + "/" + MyPhoto.id + "_" + MyPhoto.secret + ".jpg"
        Log.v("Mohamed","URL"+baseUrl)

        val myGrid = holder.v.findViewById<ImageView>(R.id.MyPhotoGrid)
        Glide.with(holder.v).load(baseUrl).into(myGrid)

    }
}
