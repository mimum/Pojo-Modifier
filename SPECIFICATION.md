# Specification/TODO list of this project
## Specification
### Must-have features
* Allows to recursively clean/modify following data:
  * [ ] Java Bean properties
  * [ ] Java Collections
  * [ ] Java Maps
* [ ] For any property object (member object) it allows to define custom
cleaner/modifier.
* [ ] At least some modifiers will be generic, so their developer
doesn't have to solve type safety (this is handled out-of-the-box by this project)
* [ ] Modifiers should allow following operations
  * [ ] Update of mutable object. This needs to be allowed on target class and
  its subclasses.
  * [ ] Update of immutable object. This needs to be allowed on target class.
  * [ ] Set the object to null. This needs to be allowed on target class and
  its subclasses.
* [ ] For every modifier it'll be possible to define include/exclude filter
(conditional filter which will define if the modifier should or shouldn't
act on specific property/member object
* Features of include/exclude filters
  * [ ] Will allow to be grouped with "and", "or", "not" conditions
  (there can be "and", "or", "not" filters which will act as filter containers)
  * [ ] End user can implement his own filter
  * [ ] If no filter will be defined, modifiers will be applied to all objects
  which matches modifier requirements.
  * [ ] Filters will have user-friendly builder to allow complex grouped filters.
  * Filters will allow to decide based on
    * [ ] "property/member path"
    * [ ] owning property attributes (field name, annotation on owning field)
    * [ ] objects package
    * [ ] objects annotation
    * [ ] owning property annotation. Good-to-have: This should be applied on `Collections` and `Maps` as well.
* Out-of-the-box modifier will be at least:
  * [ ] String - trim modifier
  * [ ] String - remove multiple whitespaces modifier
  * [ ] Collection - set to null empty collection.
* [ ] This project will include MIT license (https://choosealicense.com/licenses/mit/)
### Good-to-have features
* [ ] Support immutable collections (e.g. instances of `UnmodificableList` which
doesn't allow to change member objects)
* [ ] Annotation based cleanup = provide Type based and property based annotation `Modified` which will
have as parameter Modifier classes. This will mean, that certain class or property object will be modified
with defined modifier. For this it'd be also necessary to mark modifiers which have parameter-less constructor.
* [ ] Out-of-the-box modifiers:
  * [ ] Any bean - set to null empty bean (this would check all bean properties
  except ones marked with some annotation) and would set to null those, which are empty
  ( this would solve issue of Jackson including of empty objects in `Collections` which
  isn't solved yet. Note that this would be complex task.
  * [ ] ?Visitor-like? pattern, where class defines how it should be cleaned and it's
  `cleanMe` method needs to be executed by something (this is handy as Java Bean classes
  doesn't allow to have restrictions on inputs in the constructor.

## General use-cases of such tool
* cleanup of the Rest API responses (Jackson-annotated Java Beans).
### Detailed use-cases of such tool
* recursive String trimming
* recursive String whitespaces cleaning
* set to null Strings that contains whitespaces only.
* cleanup of model Java Beans without information (example: `QuantitaiveValue` model
class, which has propeties `value` and `unit` should be set to null if `value` is empty)
* clean one field if another is present (e.g. model has property `deliveryDateTime` and
`deliveryDateTimeFrame` and if `deliveryDateTime` is filled, then `deliveryDateTimeFrame` should
be emptied.
* reorder `Collections` (e.g. reorder events by timestamp). This might be handy
if you cannot use some`ordered Set`, but `List` and want to sort it before returning to the client.