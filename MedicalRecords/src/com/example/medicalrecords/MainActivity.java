package com.example.medicalrecords;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.htmlcleaner.HtmlCleaner;
import org.htmlcleaner.TagNode;

import android.support.v7.app.ActionBarActivity;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Message;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {
	//�ŧi�w��޲z����
	private LocationManager mLocationManager;
	//�إ�List�A�ݩʬ�Poi����
	private ArrayList<Poi> Pois = new ArrayList<Poi>();
	private int DISTANCE = 1000;
	public double a;
	public double b;
	public double dis;
	String ipp="192.168.1.108";
	String logi="abcd";
	String pass="abcd";
	String godl="xxxx";
	String godp="xxxx";
	int f=3000000;
	int d=1000;
	int co=0;
	int cc=0;
	int ccc=0;
	String banli="1252";
	String[] dataArray = new String[9];
	String[] dataArray2 = new String[9];
	String temp;
	String yes="���\";
	final String url = "http://203.64.84.245:8080//config.php";// �n�[�W"http://" �_�h�|�s�u����
	final String url2 = "http://203.64.84.245:8080//maintenance.php";//���פH��
	final String url3 = "http://203.64.84.245:8080/testuser.php";//���@�H��
	HtmlCleaner cleaner = new HtmlCleaner();
	//TextView text;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		  //text = (TextView)findViewById(R.id.textView1);
		final MCrypt mcrypt = new MCrypt();  
		Pois.add(new Poi("�O�٤j��" , 23.993107, 121.5901 ));
		mLocationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);


		final Button btn=(Button) findViewById(R.id.button1);
		final Button btn2=(Button) findViewById(R.id.button2);
		final EditText edt1=(EditText) findViewById(R.id.editText1);
		final EditText edt2=(EditText) findViewById(R.id.editText2);
		final EditText edt3=(EditText) findViewById(R.id.editText3);
		final EditText edt4=(EditText) findViewById(R.id.editText4);
		final EditText edt5=(EditText) findViewById(R.id.editText5);
		final TextView texx2=(TextView) findViewById(R.id.textView3);
		final TextView texx3=(TextView) findViewById(R.id.textView4);
		final TextView tex1=(TextView) findViewById(R.id.textView1);
		final TextView tex2=(TextView) findViewById(R.id.textView2);
		//final TextView mTextView=(TextView) findViewById(R.id.textView5);
		final TextView tex5=(TextView) findViewById(R.id.textView5);
		final TextView tex6=(TextView) findViewById(R.id.textView6);
		final TextView tex7=(TextView) findViewById(R.id.textView7);
		final TextView tex8=(TextView) findViewById(R.id.textView8);
		final TextView tex9=(TextView) findViewById(R.id.textView9);
		final TextView tex10=(TextView) findViewById(R.id.textView10);
		final TextView tex11=(TextView) findViewById(R.id.textView11);
		final TextView tex12=(TextView) findViewById(R.id.textView12);
		final TextView tex13=(TextView) findViewById(R.id.textView13);
		final TextView tex14=(TextView) findViewById(R.id.textView14);
		final TextView tex15=(TextView) findViewById(R.id.textView15);
		final TextView tex16=(TextView) findViewById(R.id.textView16);
		final TextView tex17=(TextView) findViewById(R.id.textView17);
		final TextView tex18=(TextView) findViewById(R.id.textView18);
		final TextView tex19=(TextView) findViewById(R.id.textView19);
		final TextView tex20=(TextView) findViewById(R.id.textView20);
		final TextView tex21=(TextView) findViewById(R.id.textView21);
		final TextView tex22=(TextView) findViewById(R.id.textView22);
		final TextView tex23=(TextView) findViewById(R.id.textView23);
		final TextView tex25=(TextView) findViewById(R.id.textView25);
		edt3.setVisibility(View.INVISIBLE);
		edt4.setVisibility(View.INVISIBLE);
		texx2.setVisibility(View.INVISIBLE);
		texx3.setVisibility(View.INVISIBLE);
		btn2.setVisibility(View.INVISIBLE);
		tex5.setVisibility(View.INVISIBLE);
		tex6.setVisibility(View.INVISIBLE);
		tex7.setVisibility(View.INVISIBLE);
		tex8.setVisibility(View.INVISIBLE);
		tex9.setVisibility(View.INVISIBLE);
		tex10.setVisibility(View.INVISIBLE);
		tex11.setVisibility(View.INVISIBLE);
		tex12.setVisibility(View.INVISIBLE);
		tex13.setVisibility(View.INVISIBLE);
		tex14.setVisibility(View.INVISIBLE);
		tex15.setVisibility(View.INVISIBLE);
		tex16.setVisibility(View.INVISIBLE);
		tex17.setVisibility(View.INVISIBLE);
		tex18.setVisibility(View.INVISIBLE);
		tex19.setVisibility(View.INVISIBLE);
		tex20.setVisibility(View.INVISIBLE);
		tex21.setVisibility(View.INVISIBLE);
		tex22.setVisibility(View.INVISIBLE);
		tex25.setVisibility(View.INVISIBLE);
		//text.setVisibility(View.INVISIBLE);

        
     	btn.setOnClickListener(new OnClickListener()
 	    
     	{
			public void onClick(View v)
			{
				banli=edt5.getText().toString();
				logi=edt1.getText().toString();
				pass=edt2.getText().toString();
				new Thread(runnable2).start();//�Ұʰ����runnable
				new Thread(runnable).start();//�Ұʰ����runnable
				mLocationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER,0,10000.0f,LocationChange);	
				dis=Distance(a,b,23.993107,121.5901);
				edt1.getText().toString().equals(logi);
				//edt1.getText().toString().equals(logi)&&edt2.getText().toString().equals(pass)
				//dataArray[1].equals("���\")
				tex5.setText(dataArray2[1]);	
				if(tex5.getText().toString().equals(yes))
				{
				   if(dis < DISTANCE && ipp.equals(getMyIp()))
				   {
			          //Uri uri=Uri.parse("http://203.64.84.245:8080//input2.php");
			          //Intent i=new Intent(Intent.ACTION_VIEW,uri);
				      //startActivity(i);

                        
						edt1.setVisibility(View.INVISIBLE);
						edt2.setVisibility(View.INVISIBLE);
						tex1.setVisibility(View.INVISIBLE);
						tex2.setVisibility(View.INVISIBLE);
						btn.setVisibility(View.INVISIBLE);
						edt5.setVisibility(View.INVISIBLE);
						tex23.setVisibility(View.INVISIBLE);
						tex5.setVisibility(View.VISIBLE);
						tex6.setVisibility(View.VISIBLE);
						tex7.setVisibility(View.VISIBLE);
						tex8.setVisibility(View.VISIBLE);
						tex9.setVisibility(View.VISIBLE);
						tex10.setVisibility(View.VISIBLE);
						tex11.setVisibility(View.VISIBLE);
						tex12.setVisibility(View.VISIBLE);
						tex13.setVisibility(View.VISIBLE);
						tex14.setVisibility(View.VISIBLE);
						tex15.setVisibility(View.VISIBLE);
						tex16.setVisibility(View.VISIBLE);
						tex17.setVisibility(View.VISIBLE);
						tex18.setVisibility(View.VISIBLE);
						tex19.setVisibility(View.VISIBLE);
						tex20.setVisibility(View.VISIBLE);
						tex21.setVisibility(View.VISIBLE);
						tex22.setVisibility(View.VISIBLE);
						tex25.setVisibility(View.VISIBLE);
			       		tex5.setText(dataArray[0]);				   
			       		tex6.setText(dataArray[1]);
			       		tex7.setText(dataArray[2]);
			       		tex8.setText(dataArray[3]);
			       		tex9.setText(dataArray[4]);
			       		tex10.setText(dataArray[5]);
			       		tex11.setText(dataArray[6]);
			       		tex12.setText(dataArray[7]);
			       		tex13.setText(dataArray[8]);
						   try {
								String decrypted = new String( mcrypt.decrypt(tex6.getText().toString()));
								String decrypted2 = new String( mcrypt.decrypt(tex7.getText().toString()));
								String decrypted3 = new String( mcrypt.decrypt(tex8.getText().toString()));
								String decrypted4 = new String( mcrypt.decrypt(tex9.getText().toString()));
								String decrypted5 = new String( mcrypt.decrypt(tex10.getText().toString()));
								String decrypted6 = new String( mcrypt.decrypt(tex11.getText().toString()));
								String decrypted7 = new String( mcrypt.decrypt(tex12.getText().toString()));
								String decrypted8 = new String( mcrypt.decrypt(tex13.getText().toString()));
								//String res = new String(mcrypt.decrypt(text.getText().toString()), "UTF-8"); 
								//String decryptedText = URLDecoder.decode(res, "UTF-8");
								tex5.setText(banli);
								tex6.setText(decrypted);
								tex7.setText(decrypted2);
								tex8.setText(decrypted3);
								tex9.setText(decrypted4);
								tex10.setText(decrypted5);
								tex11.setText(decrypted6);
								tex12.setText(decrypted7);
								tex13.setText(decrypted8);
								//text.setText(decrypted);
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} 
					         new CountDownTimer(f,d){
				            
				            @Override
				            public void onFinish() {
				                // TODO Auto-generated method stub
				                //mTextView.setText("�ϥήɶ��w���F");
				                //System.exit(0);
								tex5.setVisibility(View.INVISIBLE);
								tex6.setVisibility(View.INVISIBLE);
								tex7.setVisibility(View.INVISIBLE);
								tex8.setVisibility(View.INVISIBLE);
								tex9.setVisibility(View.INVISIBLE);
								tex10.setVisibility(View.INVISIBLE);
								tex11.setVisibility(View.INVISIBLE);
								tex12.setVisibility(View.INVISIBLE);
								tex13.setVisibility(View.INVISIBLE);
				            }

				            @Override
				            public void onTick(long millisUntilFinished) {
				                // TODO Auto-generated method stub
				                //mTextView.setText("seconds remaining:"+millisUntilFinished/1000);
				                co++;
				                if(co%30==0)
				                {
				                	//mTextView.setText("�ˬd!");
				    			   mLocationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER,0,10000.0f,LocationChange);	
				    			   dis=Distance(a,b,23.993107,121.5901);
				 				   if(dis < DISTANCE && ipp.equals(getMyIp()))
								   {
								   
								   }
				 				   else
				 				   {
									tex5.setVisibility(View.INVISIBLE);
									tex6.setVisibility(View.INVISIBLE);
									tex7.setVisibility(View.INVISIBLE);
									tex8.setVisibility(View.INVISIBLE);
									tex9.setVisibility(View.INVISIBLE);
									tex10.setVisibility(View.INVISIBLE);
									tex11.setVisibility(View.INVISIBLE);
									tex12.setVisibility(View.INVISIBLE);
									tex13.setVisibility(View.INVISIBLE);
				 				   }
				                }
				            }
				            
				        }.start();
				   }
				   else
				   {
				      Toast.makeText(v.getContext(), "�L�v���}�� !", Toast.LENGTH_LONG).show();
				   }
				}
				else if(edt1.getText().toString().equals(godl)&&edt2.getText().toString().equals(godp))
				{
					edt3.setVisibility(View.VISIBLE);
					edt4.setVisibility(View.VISIBLE);
					texx2.setVisibility(View.VISIBLE);
					texx3.setVisibility(View.VISIBLE);
					btn2.setVisibility(View.VISIBLE);
					btn.setVisibility(View.INVISIBLE);
				}
				else
				{
					Toast.makeText(v.getContext(), "�b���K�X���~!"+dataArray[1], Toast.LENGTH_LONG).show();
				}

			}
     	}
     			);
        btn2.setOnClickListener(new OnClickListener()
 	    
     	{
			public void onClick(View v)
			{
				DISTANCE=Integer.parseInt(edt3.getText().toString());
				ipp=edt4.getText().toString();
				edt3.setVisibility(View.INVISIBLE);
				edt4.setVisibility(View.INVISIBLE);
				texx2.setVisibility(View.INVISIBLE);
				texx3.setVisibility(View.INVISIBLE);
				btn2.setVisibility(View.INVISIBLE);
				btn.setVisibility(View.VISIBLE);
			}
     	}
     			);

		
	}
	Handler handler_Success = new Handler(){
		 @Override
	     public void handleMessage(Message msg) {
	    	 super.handleMessage(msg);
	         Bundle data = msg.getData();
	         String val = data.getString("key");//���Xkey�����r��s�Jval
        	 TagNode tagNode;
	        	
       	try {
       		tagNode = new HtmlCleaner().clean(val);
       		TagNode[] nodeBody = tagNode.getElementsByName("body", true);
       		final String body = nodeBody[0].getText().toString();
       		//text.setText(body);
       		String[] names = body.split(";");
       		for(String name:names){
       			if(cc<9)
       			{
       			  dataArray[cc]=name;
       			  cc++;
       			}

       		}


       		} 
       	    catch (Exception e) {
       		   e.printStackTrace();
       		}
	         //text.setText(val);
	     }


	 };

	 Handler handler_Error = new Handler(){
		 @Override
	     public void handleMessage(Message msg) {
	    	 super.handleMessage(msg);
	         Bundle data = msg.getData();
	         String val = data.getString("key");
	         Toast.makeText(getApplicationContext(), val, Toast.LENGTH_LONG).show();
	     }


	 };
	 
	 Handler handler_Nodata = new Handler(){
		 @Override
	     public void handleMessage(Message msg) {
	    	 super.handleMessage(msg);
	         Bundle data = msg.getData();
	         String val = data.getString("key");
	         Toast.makeText(getApplicationContext(), val, Toast.LENGTH_LONG).show();
	     }


	 };
	 
	 Runnable runnable = new Runnable(){
	     @Override
	     public void run() {
	         //
	         // TODO: http request.
	         //
	         Message msg = new Message();
	         Bundle data = new Bundle();
	         msg.setData(data);
	         try
	         {
	          //�s�u�� url���}
	          HttpClient httpclient = new DefaultHttpClient();
	          
	             HttpPost method = new HttpPost(url);
	             
	             //�ǭȵ�PHP
	             List< NameValuePair> vars=new ArrayList< NameValuePair>();
	             vars.add(new BasicNameValuePair("number",banli));
	             method.setEntity(new UrlEncodedFormEntity(vars,HTTP.UTF_8));
	             
	             //����PHP�^�Ǫ����
	             HttpResponse response = httpclient.execute(method);
	             HttpEntity entity = response.getEntity();

	             
	             if(entity != null){
	              data.putString("key",EntityUtils.toString(entity,"utf-8"));//�p�G���\�N�������e�s�Jkey
	              handler_Success.sendMessage(msg);
	              
	             }
	             else{
	              data.putString("key","�L���");
	              handler_Nodata.sendMessage(msg);
	             }
	          }
	          catch(Exception e){
	          data.putString("key","�s�u����");
	           handler_Error.sendMessage(msg);
	          }

	     }
	 };
		Handler handler_Success2 = new Handler(){
			 @Override
		     public void handleMessage(Message msg) {
		    	 super.handleMessage(msg);
		         Bundle data = msg.getData();
		         String val = data.getString("key");//���Xkey�����r��s�Jval
	        	 TagNode tagNode;
		        	
	       	try {
	       		tagNode = new HtmlCleaner().clean(val);
	       		TagNode[] nodeBody = tagNode.getElementsByName("body", true);
	       		final String body = nodeBody[0].getText().toString();
	       		//text.setText(body);
	       		String[] names = body.split(":");
	       		for(String name:names){
	       			if(ccc<5)
	       			{
	       			  dataArray2[ccc]=name;
	       			  ccc++;
	       			}

	       		}
	       		ccc=0;


	       		} 
	       	    catch (Exception e) {
	       		   e.printStackTrace();
	       		}
		         //text.setText(val);
		     }


		 };

		 Handler handler_Error2 = new Handler(){
			 @Override
		     public void handleMessage(Message msg) {
		    	 super.handleMessage(msg);
		         Bundle data = msg.getData();
		         String val = data.getString("key");
		         Toast.makeText(getApplicationContext(), val, Toast.LENGTH_LONG).show();
		     }


		 };
		 
		 Handler handler_Nodata2 = new Handler(){
			 @Override
		     public void handleMessage(Message msg) {
		    	 super.handleMessage(msg);
		         Bundle data = msg.getData();
		         String val = data.getString("key");
		         Toast.makeText(getApplicationContext(), val, Toast.LENGTH_LONG).show();
		     }


		 };
		 
		 Runnable runnable2 = new Runnable(){
		     @Override
		     public void run() {
		         //
		         // TODO: http request.
		         //
		         Message msg = new Message();
		         Bundle data = new Bundle();
		         msg.setData(data);
		         try
		         {
		          //�s�u�� url���}
		          HttpClient httpclient = new DefaultHttpClient();
		          
		             HttpPost method = new HttpPost(url3);
		             
		             //�ǭȵ�PHP
		             List< NameValuePair> vars=new ArrayList< NameValuePair>();
		             vars.add(new BasicNameValuePair("ID",logi));
		             vars.add(new BasicNameValuePair("PASSWD",pass));
		             method.setEntity(new UrlEncodedFormEntity(vars,HTTP.UTF_8));
		             
		             //����PHP�^�Ǫ����
		             HttpResponse response = httpclient.execute(method);
		             HttpEntity entity = response.getEntity();

		             
		             if(entity != null){
		              data.putString("key",EntityUtils.toString(entity,"utf-8"));//�p�G���\�N�������e�s�Jkey
		              handler_Success2.sendMessage(msg);
		              
		             }
		             else{
		              data.putString("key","�L���");
		              handler_Nodata2.sendMessage(msg);
		             }
		          }
		          catch(Exception e){
		          data.putString("key","�s�u����");
		           handler_Error2.sendMessage(msg);
		          }

		     }
		 };
    private String getMyIp(){
    	
        //�s�W�@��WifiManager����è��oWIFI_SERVICE

        WifiManager wifi_service = (WifiManager)getSystemService(WIFI_SERVICE);

        //���owifi��T

        WifiInfo wifiInfo = wifi_service.getConnectionInfo();

        //���oIP�A���o�|�O�@�Ӹ޲����Ʀr�A�٭n�A�ۤv����~��

        int ipAddress = wifiInfo.getIpAddress();

        //�Q�Φ첾�B��MAND�B��p��IP

        String ip = String.format("%d.%d.%d.%d",(ipAddress & 0xff),(ipAddress >> 8 & 0xff),(ipAddress >> 16 & 0xff),(ipAddress >> 24 & 0xff));

        return ip;  

    }
	public LocationListener LocationChange = new LocationListener() 
	{
		public void onLocationChanged(Location mLocation) 
		{	 
			for(Poi mPoi : Pois) 	
			{
				//for�j��N�Z���a�J�A�P�_�Z����Distance function�A�ݱa�J�ϥΪ̨��o�w��᪺�n�סB�g�סB���I���a�n�סB�g�סC 
				mPoi.setDistance(Distance(mLocation.getLatitude(),mLocation.getLongitude(),mPoi.getLatitude(),mPoi.getLongitude()));
				a=mLocation.getLatitude();
				b=mLocation.getLongitude();
				
	        }
	        	      
	        
	    }
		
		
	         
	    public void onProviderDisabled(String provider) 
	    {
	    }
	         
	    public void onProviderEnabled(String provider) 
	    {
	    }
	         
	    public void onStatusChanged(String provider, int status,Bundle extras) 
	    {
	    }

	};
	protected void onDestroy() 
	{
		super.onDestroy();
		mLocationManager.removeUpdates(LocationChange);  //�{�������ɰ���w���s
	}
	public double Distance(double longitude1, double latitude1, double longitude2,double latitude2) 
	{
		double radLatitude1 = latitude1 * Math.PI / 180;
		double radLatitude2 = latitude2 * Math.PI / 180;
		double l = radLatitude1 - radLatitude2;
		double p = longitude1 * Math.PI / 180 - longitude2 * Math.PI / 180;
		double distance = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(l / 2), 2)
		                 + Math.cos(radLatitude1) * Math.cos(radLatitude2)
		                 * Math.pow(Math.sin(p / 2), 2)));
		distance = distance * 6378137.0;
		distance = Math.round(distance * 10000) / 10000;
		    
		return distance ;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}


	public class Poi 
	{
		private String Name;        //���I���a�W��
		private double Latitude;    //���I���a�n��
		private double Longitude;   //���I���a�g��
		private double Distance;    //���I���a�Z��
	    	
	 	//�إߪ���ɻݱa�J���I���a�W�١B���I���a�n�סB���I���a�g��
		public Poi(String name , double latitude , double longitude)
		{
			//�N��T�a�J���O�ݩ�
			Name = name ;
			Latitude = latitude ;
			Longitude = longitude ;
		}
		
		//���o���a�W��
		public String getName() 
		{
			return Name;
		}

		//���o���a�n��
		public double getLatitude()
		{
			return Latitude;
		}

		//���o���a�g��
		public double getLongitude()
		{
			return Longitude;
		}
		
		//�g�J���a�Z��
		public void setDistance(double distance)
		{
			Distance = distance;
		}
		
		//�������a�Z��
		public double getDistance()
		{
			return Distance;
		}
	}
}
