DOMizer
=======

Make DOM from anything

Motivation
----------

There are various data formats: XML, JSON, YaML, etc. Java XML parsers create instance of `org.w3c.dom.Document`. `Document` can be then transformed using `javax.xml.transform.Transformer`, queried using XPath and XQuery be a source for XSLT transformation etc. Various parsers of other formats create their own data model that cannot be applied of neither XPath nor XSLT. 

However it should be easy to create implementations of `org.w3c.dom.Document` that wrap various data models and therefore expose them towards existing code that manipulates XML documents. 


Alternatives
------------
Alternative solution typically use different approach creating their own implementation of XPath. For example this is done my [HTMLCleaner](http://htmlcleaner.sourceforge.net/) and [JSONPath](https://github.com/jayway/JsonPath). Thise excellent libraries have their own disadvantages. XPath implementation of HTMLCleaner is not full. XPath syntax of JSONPath is slightly different from the standard. For example they use dots instead of slashes as a path separator. 
