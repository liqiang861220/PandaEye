package com.pandaq.pandaeye.activities;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.pandaq.pandaeye.BaseActivity;
import com.pandaq.pandaeye.R;
import com.pandaq.pandaeye.modules.dishorder.DishOrderContract;
import com.pandaq.pandaeye.modules.dishorder.DishOrderPresenter;
import com.pandaq.pandaeye.modules.dishorder.FunctionModuleActivity;
import com.pandaq.pandaeye.modules.dishorder.beans.LoginUser;
import com.pandaq.pandaeye.utils.JellyInterpolator;
import com.pandaq.pandaeye.utils.SPUtils;
import com.pandaq.pandaeye.utils.ToastUitl;
import com.pandaq.pandaeye.widget.BaseRespose;

public class LoginActivity extends BaseActivity implements OnClickListener,DishOrderContract.View {

	private TextView mBtnLogin;

	private View progress;

	private View mInputLayout;

	private float mWidth, mHeight;

	private LinearLayout mName, mPsw;
	private AnimatorSet set;
	private DishOrderPresenter mpresenter  = new DishOrderPresenter(this);

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.act_login);

		initView();
	}

	private void initView() {
		mBtnLogin = (TextView) findViewById(R.id.main_btn_login);
		progress = findViewById(R.id.layout_progress);
		mInputLayout = findViewById(R.id.input_layout);
		mName = (LinearLayout) findViewById(R.id.input_layout_name);
		mPsw = (LinearLayout) findViewById(R.id.input_layout_psw);

		mBtnLogin.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {

		mWidth = mBtnLogin.getMeasuredWidth();
		mHeight = mBtnLogin.getMeasuredHeight();

		mName.setVisibility(View.INVISIBLE);
		mPsw.setVisibility(View.INVISIBLE);

		inputAnimator(mInputLayout, mWidth, mHeight);

	}

	private void inputAnimator(final View view, float w, float h) {

	

		ValueAnimator animator = ValueAnimator.ofFloat(0, w);
		animator.addUpdateListener(new AnimatorUpdateListener() {

			@Override
			public void onAnimationUpdate(ValueAnimator animation) {
				float value = (Float) animation.getAnimatedValue();
				MarginLayoutParams params = (MarginLayoutParams) view.getLayoutParams();
				params.leftMargin = (int) value;
				params.rightMargin = (int) value;
				view.setLayoutParams(params);
			}
		});
		set = new AnimatorSet();
		ObjectAnimator animator2 = ObjectAnimator.ofFloat(mInputLayout, "scaleX", 1f, 0.5f);
		set.setDuration(1000);
		set.setInterpolator(new AccelerateDecelerateInterpolator());
		set.playTogether(animator, animator2);
		set.start();
		set.addListener(new AnimatorListener() {

			@Override
			public void onAnimationStart(Animator animation) {

			}

			@Override
			public void onAnimationRepeat(Animator animation) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onAnimationEnd(Animator animation) {

				progress.setVisibility(View.VISIBLE);
				progressAnimator(progress);
				mInputLayout.setVisibility(View.INVISIBLE);
				recovery();

			}

			@Override
			public void onAnimationCancel(Animator animation) {
				// TODO Auto-generated method stub

			}
		});

		mpresenter.userLogin("w1","123");

	}

	private void progressAnimator(final View view) {
		PropertyValuesHolder animator = PropertyValuesHolder.ofFloat("scaleX", 0.5f, 1f);
		PropertyValuesHolder animator2 = PropertyValuesHolder.ofFloat("scaleY", 0.5f, 1f);
		ObjectAnimator animator3 = ObjectAnimator.ofPropertyValuesHolder(view, animator, animator2);
		animator3.setDuration(1000);
		animator3.setInterpolator(new JellyInterpolator());
		animator3.start();

	}

	/**
	 * 恢复初始状态
	 */
	private void recovery() {
		progress.setVisibility(View.GONE);
		mInputLayout.setVisibility(View.VISIBLE);
		mName.setVisibility(View.VISIBLE);
		mPsw.setVisibility(View.VISIBLE);

		MarginLayoutParams params = (MarginLayoutParams) mInputLayout.getLayoutParams();
		params.leftMargin = 0;
		params.rightMargin = 0;
		mInputLayout.setLayoutParams(params);
		
		
		ObjectAnimator animator2 = ObjectAnimator.ofFloat(mInputLayout, "scaleX", 0.5f,1f );
		animator2.setDuration(500);
		animator2.setInterpolator(new AccelerateDecelerateInterpolator());
		animator2.start();
	}

	@Override
	public void showRefreshBar() {

	}

	@Override
	public void hideRefreshBar() {

	}


	@Override
	public void loginSuccessed(BaseRespose<LoginUser> respose) {
		ToastUitl.showLong(respose.msg);
		SPUtils.putStringValue("token",respose.getData().getToken());
		new Handler().postDelayed(new Runnable() {
			public void run() {
				set.end();
			}
		}, 1000);

        startActivity(FunctionModuleActivity.class);
		finish();


	}

	@Override
	public void loginFail(String errMsg) {
		ToastUitl.showLong(errMsg);
	}
}
