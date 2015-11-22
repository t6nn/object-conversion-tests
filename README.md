[![Build Status](https://api.travis-ci.org/t6nn/object-conversion-tests.png?branch=master)](https://travis-ci.org/t6nn/object-conversion-tests) <br/>

# Object Conversion in Java
This here is a set of examples on how one might solve a specific problem in Java - the Object Conversion Problem (OCP).
These are just examples, nothing more or less. The owner of the repository has no direct affiliation to any of the frameworks 
used.

## Problem Description
The Object Conversion Problem is a problem where we want to convert an instance of a specific class in our domain model
into an instance of another class, without necessarily having direct type compatibility between the classes. 
For example, converting a `java.lang.Double` into a `java.math.BigDecimal` requires creating a new instance of `BigDecimal`
with the primitive `double` value as a constructor argument, while the conversion the other way requires calling 
`BigDecimal#doubleValue()` and boxing the result. For more complex domain types, the conversion process can involve the
conversion of the internal state of the types and can often be very domain-specific.

On the other hand, frameworks that deal with domain-specific types do not have direct access to the domain information on
how to perform these conversions. Therefore, the conversion rules or conversion logic should be provided by the domain
to the framework. The exact way of how this could be provided, is the main problem that the examples provided in this repository
are created to resolve.

## Test Domain Definition
For the purpose of these examples, we will define three domain classes (under /conversion-model):
- Currency - an `enum`, representing currencies supported in our domain.
- Money - Represents a monetary value that has a currency assigned to it.
- TransactionList - a list of monetary values.

Within the scope of the examples, we attempt to implement support for the following conversions:
- Conversions between (some) compatible built-in Java types.
- All domain types to `String` and back, for serialization purposes.
- `Money` to `TransactionList`, to create a list containing a single transaction.
- `Money` to BigDecimal, dropping the currency in the process (a lossy conversion).

## Technologies Used
- [Joda-Convert](http://www.joda.org/joda-convert/) version 1.2, example under /converter-joda
- [Spring-Core](http://docs.spring.io/spring/docs/current/spring-framework-reference/html/validation.html) version 4.2.2.RELEASE, example under /converter-spring