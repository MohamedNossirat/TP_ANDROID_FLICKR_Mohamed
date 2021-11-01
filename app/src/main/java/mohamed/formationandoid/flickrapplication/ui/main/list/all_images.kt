package mohamed.formationandoid.flickrapplication.ui.main.list

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import mohamed.formationandoid.flickrapplication.R
import mohamed.formationandoid.flickrapplication.model.Photo

class all_images : Fragment() {

    companion object {
        fun newInstance() = all_images()
    }

    private lateinit var viewModel: AllImagesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val layout = inflater.inflate(R.layout.all_images_fragment, container, false)
        val resycler = layout.findViewById<RecyclerView>(R.id.RecycleView)
        viewModel = AllImagesViewModel()

        viewModel.photo.observe(this,{
            photosListe->resycler.layoutManager = GridLayoutManager(requireActivity(),2)
            resycler.adapter = Adapter(photosListe)
        })
        //val photosObservees = Observer<List<Photo>>{
            //observedPhoto -> resycler.layoutManager = GridLayoutManager(requireActivity(),2)
            //resycler.adapter = Adapter(observedPhoto)
        //}
        return  layout
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(AllImagesViewModel::class.java)
        // TODO: Use the ViewModel
    }

}