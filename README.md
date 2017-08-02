# AndroidInAppBilling
How to

To get a Git project into your build:

#Step 1. Add the JitPack repository to your build file

1)maven ,
2)sbt ,
3)leiningen.

Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}Copy
	
# Step 2. Add the dependency

	dependencies {
	        compile 'com.github.uthayacloud:AndroidInAppBilling:0.1.2'
	}
That's it! The first time you request a project JitPack checks out the code, builds it and serves the build artifacts.

If the project doesn't have any GitHub Releases you can use the short commit hash or 'anyBranch-SNAPSHOT' as the version.

# Step 3. Add the JitPack repository to your build file using Maven
	<repositories>
		<repository>
		    <id>jitpack.io</id>
		    <url>https://jitpack.io</url>
		</repository>
	</repositories>
	
	
# Add the dependency
    <dependency>
            <groupId>com.github.uthayacloud</groupId>
            <artifactId>AndroidInAppBilling</artifactId>
            <version>0.1.2</version>
        </dependency>
        
# Step 4. Add this line when you call payment 

* pass your SKU_ID
* Licensing & in-app billing
Licensing allows you to prevent unauthorized distribution of your app. It can also be used to verify in-app billing 	purchases. Learn more about licensing.

Your license key for your Application find Services and API Menu 
Base64-encoded RSA public key to include in your binary.

        new HomeActivity(this, "younity.bestofguide", Base64-encoded); // String = SKU_ID, String = Base64

# Step 5. Add below line to your activity get back response

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
            if (resultCode == Activity.RESULT_OK) {
                Intent intent = getIntent();
                Bundle args = intent.getBundleExtra("PurchaseBundle");
                List<Purchase> object = (List<Purchase>) args.getSerializable("result");
            }
    }
    
    
# Step 6. Generate product list in your google play account 

        * Create SKU_Id in google play.
         
             https://developer.android.com/google/play/billing/billing_admin.html