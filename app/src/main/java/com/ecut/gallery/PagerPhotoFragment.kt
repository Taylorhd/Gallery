package com.ecut.gallery


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import kotlinx.android.synthetic.main.fragment_pager_photo.*

/**
 * A simple [Fragment] subclass.
 */
class PagerPhotoFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pager_photo, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val photoList :ArrayList<PhotoItem>? = arguments?.getParcelableArrayList<PhotoItem>("PHOTO_LIST")
        PagerPhotoListAdapter().apply {
            viewpager2.adapter = this
            submitList(photoList)

        }

        viewpager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                photoTag.text = "${position+1}/${photoList?.size}"
            }
        })
        viewpager2.setCurrentItem(arguments?.getInt("PHOTO_POSTION")?:0,false )
    }
}
