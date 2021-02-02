/*
 * Created by Sakthi
 * on 03/02/2020 11:41 PM
 */

This repo contains Automated test for flipkart web application
-Have used Selenium webdriver and programmed in Java.
-Developed with Linux Intellij Idea

Pre-requisites:
1) Make sure to select Java 1.8 in project settings
2) Make sure to add below in VM Options on Maven Runner configuration to avoid Maven runner failure:
-ea -Dtestng.dtd.http=true
3) Make sure to Update registered mobile number and password in data.properties file.
   Otherwise scrip script will fail due to OTP verification field display for new account registration.

Other Info:
Using item: OPPO A5s (Blue, 32 GB) due to stock non-availability for OPPO A3s (Purple, 16 GB) 

Test Scenario Automated:
a. Open https://www.flipkart.com/ in an un-signed state
b. Go to Electronics/Mobile section, choose OPPO
c. Click on View All button in front of text Oppo Mobiles under ₹10K
d. Scroll down, Select item with name OPPO A3s (Purple, 16 GB)
e. Click on ‘Add to Cart’
f. Click on Flipkart main icon to go back to home screen
g.  Click on Cart and verify if item exists in the page.
h. Click on Place Order
i. Login using registered account.
j.  Add order confirmation email(if required) and press continue
k.  On payments options, select net banking, select Corporation Bank
l. Take screenshot of the Bank screen.

Additional changes:
-Generating ExtentReports for the Tests.
-Implemented Listener and capturing screenshot on Test failures.