package jp.gcreate.sample.fragmentconstructorsample

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory

class HasArgumentsFragmentFactory(val dep: () -> Int) : FragmentFactory() {
    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
        if (className == HasArgumentsFragment::class.java.name) {
            return HasArgumentsFragment(dep())
        }
        return super.instantiate(classLoader, className)
    }
}