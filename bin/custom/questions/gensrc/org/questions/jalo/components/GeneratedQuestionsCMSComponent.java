/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at Jul 13, 2021 5:58:11 PM                     ---
 * ----------------------------------------------------------------
 */
package org.questions.jalo.components;

import de.hybris.platform.cms2.jalo.contents.components.AbstractCMSComponent;
import de.hybris.platform.jalo.Item.AttributeMode;
import de.hybris.platform.jalo.SessionContext;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.questions.constants.QuestionsConstants;

/**
 * Generated class for type {@link org.questions.jalo.components.QuestionsCMSComponent QuestionsCMSComponent}.
 */
@SuppressWarnings({"deprecation","unused","cast","PMD"})
public abstract class GeneratedQuestionsCMSComponent extends AbstractCMSComponent
{
	/** Qualifier of the <code>QuestionsCMSComponent.numberOfQuestionsToShow</code> attribute **/
	public static final String NUMBEROFQUESTIONSTOSHOW = "numberOfQuestionsToShow";
	/** Qualifier of the <code>QuestionsCMSComponent.fontSize</code> attribute **/
	public static final String FONTSIZE = "fontSize";
	protected static final Map<String, AttributeMode> DEFAULT_INITIAL_ATTRIBUTES;
	static
	{
		final Map<String, AttributeMode> tmp = new HashMap<String, AttributeMode>(AbstractCMSComponent.DEFAULT_INITIAL_ATTRIBUTES);
		tmp.put(NUMBEROFQUESTIONSTOSHOW, AttributeMode.INITIAL);
		tmp.put(FONTSIZE, AttributeMode.INITIAL);
		DEFAULT_INITIAL_ATTRIBUTES = Collections.unmodifiableMap(tmp);
	}
	@Override
	protected Map<String, AttributeMode> getDefaultAttributeModes()
	{
		return DEFAULT_INITIAL_ATTRIBUTES;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>QuestionsCMSComponent.fontSize</code> attribute.
	 * @return the fontSize
	 */
	public Integer getFontSize(final SessionContext ctx)
	{
		return (Integer)getProperty( ctx, FONTSIZE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>QuestionsCMSComponent.fontSize</code> attribute.
	 * @return the fontSize
	 */
	public Integer getFontSize()
	{
		return getFontSize( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>QuestionsCMSComponent.fontSize</code> attribute. 
	 * @return the fontSize
	 */
	public int getFontSizeAsPrimitive(final SessionContext ctx)
	{
		Integer value = getFontSize( ctx );
		return value != null ? value.intValue() : 0;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>QuestionsCMSComponent.fontSize</code> attribute. 
	 * @return the fontSize
	 */
	public int getFontSizeAsPrimitive()
	{
		return getFontSizeAsPrimitive( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>QuestionsCMSComponent.fontSize</code> attribute. 
	 * @param value the fontSize
	 */
	public void setFontSize(final SessionContext ctx, final Integer value)
	{
		setProperty(ctx, FONTSIZE,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>QuestionsCMSComponent.fontSize</code> attribute. 
	 * @param value the fontSize
	 */
	public void setFontSize(final Integer value)
	{
		setFontSize( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>QuestionsCMSComponent.fontSize</code> attribute. 
	 * @param value the fontSize
	 */
	public void setFontSize(final SessionContext ctx, final int value)
	{
		setFontSize( ctx,Integer.valueOf( value ) );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>QuestionsCMSComponent.fontSize</code> attribute. 
	 * @param value the fontSize
	 */
	public void setFontSize(final int value)
	{
		setFontSize( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>QuestionsCMSComponent.numberOfQuestionsToShow</code> attribute.
	 * @return the numberOfQuestionsToShow
	 */
	public Integer getNumberOfQuestionsToShow(final SessionContext ctx)
	{
		return (Integer)getProperty( ctx, NUMBEROFQUESTIONSTOSHOW);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>QuestionsCMSComponent.numberOfQuestionsToShow</code> attribute.
	 * @return the numberOfQuestionsToShow
	 */
	public Integer getNumberOfQuestionsToShow()
	{
		return getNumberOfQuestionsToShow( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>QuestionsCMSComponent.numberOfQuestionsToShow</code> attribute. 
	 * @return the numberOfQuestionsToShow
	 */
	public int getNumberOfQuestionsToShowAsPrimitive(final SessionContext ctx)
	{
		Integer value = getNumberOfQuestionsToShow( ctx );
		return value != null ? value.intValue() : 0;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>QuestionsCMSComponent.numberOfQuestionsToShow</code> attribute. 
	 * @return the numberOfQuestionsToShow
	 */
	public int getNumberOfQuestionsToShowAsPrimitive()
	{
		return getNumberOfQuestionsToShowAsPrimitive( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>QuestionsCMSComponent.numberOfQuestionsToShow</code> attribute. 
	 * @param value the numberOfQuestionsToShow
	 */
	public void setNumberOfQuestionsToShow(final SessionContext ctx, final Integer value)
	{
		setProperty(ctx, NUMBEROFQUESTIONSTOSHOW,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>QuestionsCMSComponent.numberOfQuestionsToShow</code> attribute. 
	 * @param value the numberOfQuestionsToShow
	 */
	public void setNumberOfQuestionsToShow(final Integer value)
	{
		setNumberOfQuestionsToShow( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>QuestionsCMSComponent.numberOfQuestionsToShow</code> attribute. 
	 * @param value the numberOfQuestionsToShow
	 */
	public void setNumberOfQuestionsToShow(final SessionContext ctx, final int value)
	{
		setNumberOfQuestionsToShow( ctx,Integer.valueOf( value ) );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>QuestionsCMSComponent.numberOfQuestionsToShow</code> attribute. 
	 * @param value the numberOfQuestionsToShow
	 */
	public void setNumberOfQuestionsToShow(final int value)
	{
		setNumberOfQuestionsToShow( getSession().getSessionContext(), value );
	}
	
}
