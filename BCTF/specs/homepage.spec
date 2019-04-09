#Declaring objects with css and xpath locators
@objects
  header               css     div.fusion-secondary-header
 
#Home Page Tag
= Home Page =
  #This is for Desktop
   @on desktop
       #Header properties
       header:
           inside screen 0px top
           inside screen 0px left
           inside screen 0px right