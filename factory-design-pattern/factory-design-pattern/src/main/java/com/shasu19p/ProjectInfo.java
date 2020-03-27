package com.shasu19p;

/**
 * Factory design pattern: Creational design pattern 
 * 
 * Description:
 * - It follows the principle of 'define an interface or abstract class
 * for an object, but let factory class let decide which concrete class
 * to return on demand'
 * 
 * Example: 
 * 	- consider, there are three companies giving networking services
 *  - Airtel at rate of 2ps per second call rate
 *  - Idea at 1.5 ps per second call rate
 *  - Reliance 1.2 ps per second
 * 
 * 	-------------------
 * Consider, one customer is using some network (we don't know in advance)
 * and we are given work of billing. We know that there will be one network service
 * provider and as per it's call rate charges, for total number of minutes, we need 
 * to calculate the amount to charge.
 * 
 *  Create a solution for billing class.
 *  
 *  Billing Class ----> Gets network provider (Airtel, Idea or Reliance at runtime)
 *  
 *  Create one class which will give provider but just passing service provider name.
 *  
 * 
 * */
