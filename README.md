# binding-str

`binding-str` allows you to specify binding variables directly inside
a string. During the evaluation of the binding-str macro the
variables get replaced with the actual content. If the binding can
not be found a compile error will be thrown.
  
The format of the binding specification is currently based on the
quoting syntax of Clojure, here is a little example:
              
    de.herr-norbert.binding-str.core>
       (let [name \"World\"]
         (binding-str \"Hello `(name)!\"))
    \"Hello World!\"

## License

Copyright (C) 2011 FIXME

Distributed under the Eclipse Public License, the same as Clojure.
