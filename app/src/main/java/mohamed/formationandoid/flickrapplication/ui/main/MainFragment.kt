package mohamed.formationandoid.flickrapplication.ui.main

import android.annotation.SuppressLint
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import mohamed.formationandoid.flickrapplication.R
import mohamed.formationandoid.flickrapplication.model.Photo

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    @SuppressLint("FragmentLiveDataObserve")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        var baseUrl : String = ""
        val layout = inflater.inflate(R.layout.main_fragment, container, false)
        val title = layout.findViewById<TextView>(R.id.photoText)
        val image = layout.findViewById<ImageView>(R.id.photoLoaded)
        val button_all = layout.findViewById<Button>(R.id.allPhotos)
        val button_next = layout.findViewById<Button>(R.id.nextButton)

        val photo_observee = Observer<Photo>{
             Photo ->
                baseUrl = "https://live.staticflickr.com/" + Photo.server + "/" + Photo.id + "_" + Photo.secret + ".jpg"
            title.text = Photo.title

            Glide.with(layout).load(baseUrl).into(image)
        }
        viewModel.photos.observe(this,photo_observee)
        button_next.setOnClickListener(){
            viewModel.next()
        }

        return layout
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        // TODO: Use the ViewModel
    }

}