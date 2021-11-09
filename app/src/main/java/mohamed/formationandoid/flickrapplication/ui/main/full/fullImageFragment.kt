package mohamed.formationandoid.flickrapplication.ui.main.full

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide
import mohamed.formationandoid.flickrapplication.R
import mohamed.formationandoid.flickrapplication.ui.main.list.all_images

class fullImageFragment : Fragment() {

    companion object {
        fun newInstance() = fullImageFragment()
    }

    private lateinit var viewModel: FullImageViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val layout =  inflater.inflate(R.layout.full_image_fragment, container, false)

        val fullImage = layout.findViewById<ImageView>(R.id.FullImage)
        val url = fullImageFragmentArgs.fromBundle(requireArguments()).url
        Glide.with(layout).load(url).into(fullImage);
        return layout
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(FullImageViewModel::class.java)
        // TODO: Use the ViewModel
    }

}