This are the steps to start : 


1. REGISTERING THE RESTUARENT:
   
     To register as a restaurant , we need to enter the restaurnat name, and restaurant email . Email is used for uniqueness of the restaurant .


<img width="901" alt="image" src="https://github.com/user-attachments/assets/9865eb7b-dce5-4caf-9f0c-88a391fde659">


     If you try to register with the same email again,  then you will get a conflict : 409 


<img width="901" alt="image" src="https://github.com/user-attachments/assets/0eb86d16-6e0c-4fde-b9b7-f29da69f89a9">


2. ADDING THE MENU ITEMS IN THE REGISTERED RESTAURANT:

   These are the currently registered Restaurants:

      <img width="901" alt="image" src="https://github.com/user-attachments/assets/f7c09b78-98ea-480e-8c37-3e2dc9d728a3">

   We can add any number of menu-items under the particular restuarant . The restuarant under which you are trying to add the menu-items should already be registered . Otherwise you can't add the menu-items .

   
   <img width="899" alt="image" src="https://github.com/user-attachments/assets/3b47e1f8-f553-4004-984f-e076b609e6f6">

   If we try to add the menu under which the restuarant is not found , then the system will give you a Bad Request and says that "Restuarant with {id} is not registered"

   <img width="901" alt="image" src="https://github.com/user-attachments/assets/b3f7fa40-2f49-437f-beda-026a06a0a848">


   We can list all the items in the menu :


   <img width="901" alt="image" src="https://github.com/user-attachments/assets/93772132-6985-4aa6-b92c-189ddf814ed5">

