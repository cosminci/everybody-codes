package com.github.cosminci.ec

import scala.io.Source
import scala.util.Using

package object utils {

  def loadInputAsStrings(path: String): Seq[String] =
    Using.resource(Source.fromResource(path))(_.getLines().toSeq)

}
