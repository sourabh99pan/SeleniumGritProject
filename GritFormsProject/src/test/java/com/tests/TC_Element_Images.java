package com.tests;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.vsysq.base.TestBase;

import Generic_TestClass.ElementsGeneric;

public class TC_Element_Images extends TestBase {

	ElementsGeneric obj = new ElementsGeneric();
	@Test
	public void brokenImage()
	{
		driver.findElement(By.id("item-6")).click();
        // Storing all elements with img tag in a list of WebElements
        List<WebElement> images = driver.findElements(By.tagName("img"));
        System.out.println("Total number of Images on the Page are " + images.size());
        
        
        //checking the links fetched.
        for(int index=0;index<images.size();index++)
        {
            WebElement image= images.get(index);
            String imageURL= image.getAttribute("src");
            System.out.println("URL of Image " + (index+1) + " is: " + imageURL);
            obj.verifyLinks(imageURL);
          
            //Validate image display using JavaScript executor
            try {
                boolean imageDisplayed = (Boolean) ((JavascriptExecutor) driver).executeScript("return (typeof arguments[0].naturalWidth !=\"undefined\" && arguments[0].naturalWidth > 0);", image);
                if (imageDisplayed) {
                    System.out.println("DISPLAY - Image is OK");
                }else {
                     System.out.println("DISPLAY - Image is BROKEN");
                }
            } 
            catch (Exception e) {
             System.out.println("Error Occured");
            }
        }
	}
	

}
