(ns de.herr-norbert.binding-str.test.core
  (:use [de.herr-norbert.binding-str.core])
  (:use [clojure.test]))

(deftest binding-strstr_should_generate_normal_strings
  (is (= "Hallo World!" (binding-str "Hallo World!")))
  (is (= "1234" (binding-str "1" \2 "34"))))

(deftest binding-str_should_create_strings_with_one_replaced_binding
  (let [name "world"]
    (is (= "Hello world!" (binding-str "Hello `(name)!")))))

(deftest binding-str_should_replace_multiple_bindings
  (let [one "One" two "Two" three "Three"]
    (is (= "One .. Two .. Three .. Go!!"
           (binding-str "`(one) .. `(two) .. `(three) .. Go!!")))))

(deftest binding-str_should_take_multiple_parameters
  (let [name "World"]
    (is (= "Hello World and Goodbye!"
           (binding-str "Hello `(name)" " and Goodbye!")))))

