package com.guoshi.module_main

import android.databinding.DataBindingUtil
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v4.view.ViewPager
import android.os.Bundle
import android.view.KeyEvent
import android.view.MenuItem
import android.widget.Toast

import com.alibaba.android.arouter.facade.annotation.Route
import com.guoshi.baselib.base.BaseActivity
import com.guoshi.baselib.utils.StatusBarUtil

import java.util.ArrayList

import com.guoshi.baselib.route.MainUtlis
import com.guoshi.module_attention.StudyFragment
import com.guoshi.module_home.HomeFragment
import com.guoshi.module_main.adapter.MainFragmentAdapter
import com.guoshi.module_main.databinding.ActivityMainBinding
import com.guoshi.module_mine.MineFragment
import com.guoshi.module_news.OptionalFragment
import com.yanzhenjie.permission.AndPermission
import com.yanzhenjie.permission.runtime.Permission

/**
 * 国时智能
 * 作者：knight.he
 * 创建时间：2019/3/4
 * 文件描述：根界面
 */
@Route(path = MainUtlis.MAIN)
class MainActivity : BaseActivity() {
    private var binding: ActivityMainBinding? = null
    private val TAG = "MainActivity"
    private var fragmentList: ArrayList<Fragment>? = null
    private var adapter: MainFragmentAdapter? = null
    private var homeFragment: HomeFragment? = null
    private var studyFragment: StudyFragment? = null
    private var optionalFragment: OptionalFragment? = null
    private var mineFragment: MineFragment? = null
    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        val i = item.itemId
        if (i == R.id.navigation_home) {
            binding!!.viewpager.setCurrentItem(0, false)
            return@OnNavigationItemSelectedListener true
        } else if (i == R.id.navigation_focusOn) {
            binding!!.viewpager.setCurrentItem(1, false)
            return@OnNavigationItemSelectedListener true
        } else if (i == R.id.navigation_news) {
            binding!!.viewpager.setCurrentItem(2, false)

            return@OnNavigationItemSelectedListener true
        } else if (i == R.id.navigation_mine) {
            binding!!.viewpager.setCurrentItem(3, false)
            return@OnNavigationItemSelectedListener true
        }
        false
    }

    //连续点击2次退出app
    private var firstTime: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        StatusBarUtil.setStatusBarLightMode(this)
        initview()
    }

    private fun initview() {
        //BottomNavigationView配置
        binding!!.navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        binding!!.navigation.itemIconTintList = null
        binding!!.navigation.itemTextColor = resources.getColorStateList(R.color.navigation_menu_item_color)
        //viepager配置
        fragmentList = ArrayList()
        homeFragment = HomeFragment()
        studyFragment = StudyFragment()
        optionalFragment = OptionalFragment()
        mineFragment = MineFragment()
        fragmentList!!.add(homeFragment!!)
        fragmentList!!.add(studyFragment!!)
        fragmentList!!.add(optionalFragment!!)
        fragmentList!!.add(mineFragment!!)
        adapter = MainFragmentAdapter(supportFragmentManager, fragmentList!!)
        binding!!.viewpager.adapter = adapter
        binding!!.viewpager.setScanScroll(false)
        binding!!.viewpager.offscreenPageLimit = 4
        //设置viewPager点击事件
        binding!!.viewpager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

            }

            override fun onPageSelected(position: Int) {
                binding!!.navigation.menu.getItem(position).isChecked = true
            }

            override fun onPageScrollStateChanged(state: Int) {

            }
        })
        /**设置MenuItem默认选中项 */

        binding!!.navigation.menu.getItem(0).isChecked = true
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent): Boolean {
        val secondTime = System.currentTimeMillis()

        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (secondTime - firstTime < 2000) {
                System.exit(0)
            } else {
                Toast.makeText(applicationContext, "再按一次返回键退出", Toast.LENGTH_SHORT).show()
                firstTime = System.currentTimeMillis()
            }
            return true
        }
        return super.onKeyDown(keyCode, event)
    }


    //    public void getData() {
    //        Observable observable1= RetrofitFactory.getInstence().API()
    //                .mainPagehotSearch()
    //                .compose(this.<BaseEntity>setThread());
    //
    ////        Observable observable=Observable.merge(observable1,observable2);
    //        observable2
    //                .subscribeOn(Schedulers.io()) // 指定 subscribe() 发生在 IO 线程
    //                .observeOn(AndroidSchedulers.mainThread()) // 指定 Subscriber 的回调发生在主线程
    //                .subscribe(new BaseObserver<Object>(){
    //                    @Override
    //                    protected void onSuccees(BaseEntity<Object> t)throws Exception {
    //                        if(t.getResult() instanceof List){
    //                            Log.e("1111111111",((List<ABean>)t.getResult()).size()+"");
    //                            CustomToast.showToast(MainActivity.this,((List<ABean>)t.getResult()).size()+"");
    //                        }
    //                    }
    //
    //
    //                    @Override
    //                    protected void onFailure(Throwable e, boolean isNetWorkError) throws Exception {
    //
    //                        Log.e("1112",e.getMessage()+"");
    //                    }
    //
    //
    //                });

    //Rxjava
    //        Observable.create(new ObservableOnSubscribe<Integer>() {//第一步  初始化Observable
    //            @Override
    //            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
    //                Log.e(TAG, "Observable emit 1" + "\n");
    //                emitter.onNext(1);
    //                Log.e(TAG, "Observable emit 2" + "\n");
    //                emitter.onNext(2);
    //                Log.e(TAG, "Observable emit 3" + "\n");
    //                emitter.onNext(3);
    //                emitter.onComplete();
    //                Log.e(TAG, "Observable emit 4" + "\n" );
    //                emitter.onNext(4);
    //            }
    //        })
    //        .subscribeOn(Schedulers.io()) // 指定 subscribe() 发生在 IO 线程
    //        .observeOn(AndroidSchedulers.mainThread()) // 指定 Subscriber 的回调发生在主线程
    //         .subscribe(new Observer<Integer>() {// 第三部：订阅
    //
    //            //第二部：初始化Observer
    //            private int i;
    //            private Disposable disposable;
    //
    //            @Override
    //            public void onSubscribe(Disposable d) {
    //                disposable=d;
    //            }
    //
    //            @Override
    //            public void onNext(Integer o) {
    //                i++;
    ////                if(o==2){
    ////                    // 在RxJava 2.x 中，新增的Disposable可以做到切断的操作，让Observer观察者不再接收上游事件
    ////                    disposable.dispose();
    ////                }
    //            }
    //
    //            @Override
    //            public void onError(Throwable e) {
    //                Log.e(TAG, "onError : value : " + e.getMessage() + "\n" );
    //            }
    //
    //            @Override
    //            public void onComplete() {
    //                Log.e(TAG, "onComplete" + "\n" );
    //            }
    //        });
    //    }

    //    public void upload(){
    //        String filepath="图片本地路径";
    //        UploadUtil.uploadImage(filepath, new Observer() {
    //            @Override
    //            public void onSubscribe(Disposable d) {
    //
    //            }
    //
    //            @Override
    //            public void onNext(Object o) {
    //
    //            }
    //
    //            @Override
    //            public void onError(Throwable e) {
    //
    //            }
    //
    //            @Override
    //            public void onComplete() {
    //
    //            }
    //        });
    //    }
    //
    //    public void uploads(){
    //        ArrayList<String> listFilePath=new ArrayList<>();
    //        listFilePath.add("图片1路径");
    //        listFilePath.add("图片2路径");
    //        UploadUtil.uploadImages(listFilePath, new Observer() {
    //            @Override
    //            public void onSubscribe(Disposable d) {
    //
    //            }
    //
    //            @Override
    //            public void onNext(Object o) {
    //
    //            }
    //
    //            @Override
    //            public void onError(Throwable e) {
    //
    //            }
    //
    //            @Override
    //            public void onComplete() {
    //
    //            }
    //        });
    //    }
}
