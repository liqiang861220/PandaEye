package com.pandaq.pandaeye.modules.dishorder.beans;


import android.content.Context;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;

import com.pandaq.pandaeye.modules.dishorder.utils.ViewUtils;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class FoodBean implements Serializable {

	/**
	 * id : 1
	 * sid : 1
	 * cid : 1
	 * name : 龙凤小炒
	 * slogan : 好吃不贵
	 * img : http://api.wsrok.com/uploads/2658972483ae87e1eb49b0708b3d8509/foods/5af81be0db18b.jpg
	 * price : 20.00
	 * sale_count : 26
	 * spec : [{"name":"不辣"},{"name":"爆辣"}]
	 * description :
	 * is_show : 1
	 * sort : 500
	 * min : 1
	 * max : 0
	 * unit : 份
	 */

	private int id;
	private int cid;
	private String name;
	private String slogan;
	private String img;
	private BigDecimal price;
	private int sale_count;
	private String description;
	private int is_show;
	private int sort;
	private int min;
	private int max;
	private String unit;
	private List<SpecBean> spec;
	private long selectCount;
	private int icon;//图片
	private String type;//类;
	private int voteSize ;//下单数量

	public int getIcon() {
		return icon;
	}

	public void setIcon(int icon) {
		this.icon = icon;
	}

	public long getSelectCount() {
		return selectCount;
	}

	public void setSelectCount(long selectCount) {
		this.selectCount = selectCount;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}



	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSlogan() {
		return slogan;
	}

	public void setSlogan(String slogan) {
		this.slogan = slogan;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public int getSale_count() {
		return sale_count;
	}

	public void setSale_count(int sale_count) {
		this.sale_count = sale_count;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getIs_show() {
		return is_show;
	}

	public void setIs_show(int is_show) {
		this.is_show = is_show;
	}

	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}

	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public List<SpecBean> getSpec() {
		return spec;
	}

	public void setSpec(List<SpecBean> spec) {
		this.spec = spec;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getVoteSize() {
		return voteSize;
	}

	public void setVoteSize(int voteSize) {
		this.voteSize = voteSize;
	}

	public SpannableString getStrPrice(Context context) {
		String priceStr = String.valueOf(getPrice());
		SpannableString spanString = new SpannableString("¥" + priceStr);
		AbsoluteSizeSpan span = new AbsoluteSizeSpan(ViewUtils.sp2px(context, 11));
		spanString.setSpan(span, 0, 1, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
		return spanString;
	}

	public SpannableString getStrPrice(Context context, BigDecimal price) {
		String priceStr = String.valueOf(price);
		SpannableString spanString = new SpannableString("¥" + priceStr);
		AbsoluteSizeSpan span = new AbsoluteSizeSpan(ViewUtils.sp2px(context, 11));
		spanString.setSpan(span, 0, 1, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
		return spanString;
	}

	public static class SpecBean implements Serializable{
		/**
		 * name : 不辣
		 */

		private String name;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
	}
}
