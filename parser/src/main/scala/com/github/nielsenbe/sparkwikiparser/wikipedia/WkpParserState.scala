/** Copyright 2017
  * Licensed under the Apache License, Version 2.0 (the "License");
  * you may not use this file except in compliance with the License.
  * You may obtain a copy of the License at
  *
  * http://www.apache.org/licenses/LICENSE-2.0
  *
  * Unless required by applicable law or agreed to in writing, software
  * distributed under the License is distributed on an "AS IS" BASIS,
  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  * See the License for the specific language governing permissions and
  * limitations under the License.
  */
package main.scala.com.github.nielsenbe.sparkwikiparser.wikipedia

import org.sweble.wikitext.engine.{PageId, WtEngineImpl}

/** Some state needs to be maintained as elements are parsed.  Be warned that some of these variables are mutable.
  *
  * @param articleId parent page id
  * @param articleName parent page title (used for correctly assigning intra-article bookmark links)
  * @param config parser options
  * @param swebleEngine used for when an element needs re-parsing.  Saves cost of instantiation
  * @param sweblePage used for when an element needs re-parsing.  Saves cost of instantiation
  */
class WkpParserState (
  val articleId: Int,
  val articleName: String,
  val config: WkpParserConfiguration,
  val swebleEngine: WtEngineImpl,
  val sweblePage: PageId
){
  var headerId: Int = 0
  val headerIdItr: Iterator[Int] = Stream.from(1).iterator
  val elementIdItr: Iterator[Int] = Stream.from(0).iterator
}
