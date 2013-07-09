(ns zip-example.core
  (:require [clojure.data.zip.xml :as zip-xml]
            [clojure.zip :as zip]
            [clojure.xml :as xml]
            [clojure.pprint :refer [pprint]]))

(def xml
  "<?xml version=\"1.0\" encoding=\"iso-8859-1\" ?>
<!-- <!DOCTYPE nzb PUBLIC \"-//newzBin//DTD NZB 1.1//EN \" \"http://www.newzbin.com/DTD/nzb/nzb-1.1.dtd \"> -->
<nzb xmlns=\"http://www.newzbin.com/DTD/2003/nzb\">
 <head>
   <meta type=\"title \">Your File!</meta>
   <meta type=\"tag \">Example</meta>
 </head>
 <file poster=\"Joe Bloggs &lt;bloggs@nowhere.example&gt;\" date=\"1071674882\" subject=\"Here's your file!  abc-mr2a.r01 (1/2)\">
 <groups>
 <group>alt.binaries.newzbin</group>
 <group>alt.binaries.mojo</group>
 </groups>
 <segments>
 <segment bytes= \"102394\" number= \"1\">123456789abcdef@news.newzbin.com</segment>
 <segment bytes= \"4501\" number= \"2\">987654321fedbca@news.newzbin.com</segment>
 </segments>
 </file>
 </nzb>")

(spit "test.xml" xml)
(def parsed-xml (zip/xml-zip (xml/parse "test.xml")))
(pprint (zip-xml/xml-> parsed-xml :head :meta))