package com.github.mmolimar.kukulcan

package object repl {

  val banner: String =
    """
      |                                                                                             ,/`.
      |                                                            ---_ ......._-_--.             ,'/ __`.
      |                                                           (|\ /      / /| \  \          ,'_/_  _ _`.
      |                                                           /  /     .'  -=-'   `.      ,'__/_ ___ __ `.
      |                                                          /  /    .'             )   ,'_  /___ __ _ __ `.
      | _   __        _            _                           _/  /   .'        _.)   /   '-.._/______-"-______`.
      || | / /       | |          | |                         / o   o        _.-' /  .'
      || |/ /  _   _ | | __ _   _ | |  ___   __ _  _ __       \          _.-'    / .'*|
      ||    \ | | | || |/ /| | | || | / __| / _` || '_ \       \______.-'//    .'.' \*|
      || |\  \| |_| ||   < | |_| || || (__ | (_| || | | |       \|  \ | //   .'.' _ |*|
      |\_| \_/ \__,_||_|\_\ \__,_||_| \___| \__,_||_| |_|        `   \|//  .'.'_ _ _|*|
      |                                                           .  .// .'.' | _ _ \*|
      |                                                           \`-|\_/ /    \ _ _ \*\
      |               A REPL for Apache Kafka                      `/'\__/      \ _ _ \*\
      |                                                           /^|            \ _ _ \*
      |                                                                           \_                """
      .stripMargin
      .concat(
        s"""Version: ${BuildInfo.version}
           |-----------------------------------------------------------------------------------------------------------
           |
           |""".stripMargin
      )
}