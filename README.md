# social-media-android
A mini social media feed page

HomePage =>
  Home page has been created using the recycleview. I have created a basic_layout.xml which is used to provide the sample layout to all the users data.
  The value is featched using the JSON file which is present in the assertfolder and is stored in the respected ArrayList. The data of ArrayList is transferd to 
  the repected fragment class using the Bundel and is set to the basic_layout using RecycleviewAddapter.
  
PebblesPage=>
   Pebble page is same as HomePage, but it is not created using the recycleview. In pebblespage I have designed the hole UI in home_fragment.Xml The value 
   is fetched using the Json file and values is stored in respective ArrayList. The data of ArrayList is transferd to the respected fragment class
   using the Bundle. The values of the wiged's is assigned using setText function and getText from respect ArrayList 
   
 BottomNavbar=>
    user can navigate between the respected fragments using the navbar. the create, notifiction and profile fragment has set as basic.
