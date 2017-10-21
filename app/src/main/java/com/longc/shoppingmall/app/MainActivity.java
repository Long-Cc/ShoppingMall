package com.longc.shoppingmall.app;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.widget.RadioGroup;

import com.longc.shoppingmall.Fragment.CartFragment;
import com.longc.shoppingmall.Fragment.CommunityFragment;
import com.longc.shoppingmall.Fragment.HomeFragment;
import com.longc.shoppingmall.Fragment.TypeFragment;
import com.longc.shoppingmall.Fragment.UserFragment;
import com.longc.shoppingmall.R;
import com.longc.shoppingmall.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity {

    private RadioGroup mrg_main;
    private List<BaseFragment> mBaseFragment;

    private  int position;

    private Fragment mContent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initFragment();

        mrg_main.setOnCheckedChangeListener(new myOnCheckedChangeListener());
        //默认选中CommonFrame页面
        mrg_main.check(R.id.rb_home);

    }
    class myOnCheckedChangeListener implements RadioGroup.OnCheckedChangeListener {

        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch (checkedId){
                case R.id.rb_home:
                    position = 0;
                    break;
                case R.id.rb_type:
                    position = 1;
                    break;
                case R.id.rb_community:
                    position = 2;
                    break;
                case R.id.rb_cart:
                    position = 3;
                    break;
                case R.id.rb_user:
                    position = 4;
                    break;
                default:
                    position = 0;
                    break;
            }
            //根据位置得到对应的Fragment
            BaseFragment to = getFragment();
            //替换
            switchFragment(mContent,to);


//            FragmentManager fm = getSupportFragmentManager();
//            FragmentTransaction transaction = fm.beginTransaction();
//            transaction.replace(R.id.fl_content,fragment);
//            transaction.commit();

        }
    }
    /**
     *
     * @param from 刚显示的Fragment,马上就要被隐藏了
     * @param to 马上要切换到的Fragment，一会要显示
     */
    private void switchFragment(Fragment from,Fragment to) {
        if(from != to){
            mContent = to;
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            //判断有没有被添加
            if(!to.isAdded()){
                //to没有被添加
                //隐藏from
                if(from != null){
                    ft.hide(from);
                }
                //添加to
                if(to != null){
                    ft.add(R.id.fl_content,to).commit();
                }


            }else{
                //to被添加
                //from隐藏
                if(from != null){
                    ft.hide(from);
                }
                //显示to
                if(to != null){
                    ft.show(to).commit();
                }

            }
        }
    }

    private BaseFragment getFragment() {
        return mBaseFragment.get(position);
    }

    private void initFragment() {
        mBaseFragment = new ArrayList<>();
        mBaseFragment.add(new HomeFragment());
        mBaseFragment.add(new TypeFragment());
        mBaseFragment.add(new CommunityFragment());
        mBaseFragment.add(new CartFragment());
        mBaseFragment.add(new UserFragment());
    }

    private void initView() {
        setContentView(R.layout.activity_main);
        mrg_main = (RadioGroup) findViewById(R.id.rg_main);

    }
}
