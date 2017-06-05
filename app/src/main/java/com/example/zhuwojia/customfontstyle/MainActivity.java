package com.example.zhuwojia.customfontstyle;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView tv_show;
    EditText et_content;
    Button bnt_change;
    Spinner sp_sel;
    private String[] fontRes = {"fangzhengcuyuan.ttf","fangzhengguli.ttf","fangzhenghuali.ttf","fangzhengjingleijianti.TTF","fangzhengkatongjianti.ttf",
            "fangzhengliuxingjianti.ttf","fangzhengpangtouyu.TTF","fangzhengqiyongjianti.ttf","fangzhengxiaozhuan.TTF","fangzhengyingbixingshu.TTF",
            "fangzhengzhengyuan.ttf","fangzhengzhuiyuan.TTF","huakangshaonvti.ttf","huakangwawati.TTF", "huakangzhongheiziti.TTF",
            "huawencaiyun.TTF","huawenxingkai.ttf","huawenxinsong.ttf","huawenxinwei.TTF","kaiti.ttf",
            "lishu.ttf","minglan.ttf","nuajiyanguyin.ttf","pingguolihei.ttf","popziti.ttf",
            "shoujinti.ttf","weiruanyahei.ttf","wenquanyiweimihei.ttf","youyuan.ttf"};
    private String[] fontName = {"方正粗圆","方正古隶","方正华隶","方正静蕾简体","方正卡通简体",
            "方正流行体简体","方正胖头鱼","方正启体简体","方正小篆","方正硬笔行书",
            "方正正圆","方正准圆","华康少女字体","华康娃娃体","华康中黑字体",
            "华文彩云","华文行楷","华文新宋","华文新魏","楷体",
            "隶书","明兰","诺基亚古印","苹果丽黑","pop字体",
            "瘦金体","微软雅黑","文泉驿微米黑","幼圆"};
    private AssetManager assets;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
         assets = getAssets();
        Typeface typeface = Typeface.createFromAsset(assets, fontRes[0]);
        tv_show.setTypeface(typeface);
    }

    private void initViews() {
        tv_show = (TextView) findViewById(R.id.tv_show);
        et_content = (EditText) findViewById(R.id.et_content);
        bnt_change = (Button) findViewById(R.id.bnt_change);
        sp_sel = (Spinner)findViewById(R.id.sp_sel);
        bnt_change.setOnClickListener(this);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,fontName);
        sp_sel.setAdapter(adapter);
        sp_sel.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Typeface typeface = Typeface.createFromAsset(assets, fontRes[position]);
                tv_show.setTypeface(typeface);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    @Override
    public void onClick(View v) {
        String content = et_content.getText().toString();
        if(content!=null&&!content.isEmpty()){
            tv_show.setText(content);
        }
    }
}
