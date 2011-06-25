(ns de.herr-norbert.binding-str.core
  "`binding-str` supports the evaluation of bindings inside strings.")

;; This regular expression defines the binding syntax. Bindings can be
;; accessed via ``(name-of-binding)`
(def ^{:dynamic true} *regex-matcher* #"(.*)`\((.*)\)(.*)")

(defmacro binding-str
  "`binding-str` allows you to specify binding variables directly inside
   a string. During the evaluation of the binding-str macro the
   variables get replaced with the actual content. If the binding can
   not be found a compile error will be thrown.
  
   The format of the binding specification is currently based on the
   quoting syntax of Clojure, here is a little example:
              
      de.herr-norbert.binding-str.core>
         (let [name \"World\"]
           (binding-str \"Hello `(name)!\"))
      \"Hello World!\"

 "
  ([x]
     (if-let [matches (first (re-seq *regex-matcher* x))]
       (let [[_ pre match post] matches]
         `(str (binding-str ~pre) ~(symbol match) (binding-str ~post)))
       `(str ~x)))
  ([x & ys]
     `(binding-str ~(str x (apply str ys)))))
