/* Copyright (c) 2015-2018 Smart Technology Solutions Limited. All Rights
 * Reserved.
 *
 * This software is the confidential and proprietary information of Smart
 * Technology Solutions Limited. ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in accordance
 * with the terms of the license agreement you entered into with Smart
 * Technology Solutions Limited.
 *
 * SMART TECHNOLOGY SOLUTIONS LIMITED MAKES NO REPRESENTATIONS OR WARRANTIES
 * ABOUT THE SUITABILITY OF THE SOFTWARE, EITHER EXPRESS OR IMPLIED, INCLUDING
 * BUT NOT LIMITED TO THE IMPLIED WARRANTIES OF MERCHANTABILITY, FITNESS FOR A
 * PARTICULAR PURPOSE, OR NON-INFRINGEMENT. SMART TECHNOLOGY SOLUTIONS LIMITED
 * SHALL NOT BE LIABLE FOR ANY DAMAGES SUFFERED BY LICENSEE AS A RESULT OF
 * USING, MODIFYING OR DISTRIBUTING THIS SOFTWARE OR ITS DERIVATIVES. */

package sts.test.validator.example;

import sts.test.validator.Validator;

/**
 * Example implementation of {@link Validator}. Candidates may modify this class
 * or write their own implementation.
 */
public class ValidatorExample
    implements Validator {

  /* Note: the required no-argument constructor is implicitly defined if no
   * other constructors are provided */

  /**
   * Indicate if the given message is valid.
   *
   * @param message The message to check
   * @return {@code true} if the message starts with STX, ends with ETX and the
   *         correct LRC, and has correctly-escaped data; {@code false}
   *         otherwise.
   * @todo Implement this method
   */
  public boolean isValid(byte[] message) {
    return false;
  }

}
